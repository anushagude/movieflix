package com.netflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.repository.UserTitleReviews;
import com.netflix.services.UserService;

@ComponentScan({"com.netflix.services","com.netflix.repository"})
@RestController
@RequestMapping(path = "user")
@EntityScan("com.netflix.repository")
@EnableJpaRepositories("com.netflix.repository")
@EnableAutoConfiguration
public class UserController {
	@Autowired
	private UserService userSvc;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<UserTitleReviews> findallReviews() {
		return userSvc.findAllReviews();
	}

	@RequestMapping(method = RequestMethod.GET, path = "{userId}/{movieId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserTitleReviews findOneReview(@PathVariable("userId") String userId,
			@PathVariable("movieId") String movieId) {
		return userSvc.findOneReview(userId, movieId);
	}

	@RequestMapping(method = RequestMethod.GET, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserTitleReviews findOne(@PathVariable("id") String id) {
		return userSvc.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			"application/json" }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE, "application/json" })
	public UserTitleReviews createReview(@RequestBody UserTitleReviews reviews) {
		return userSvc.createReview(reviews);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserTitleReviews updateReview(@PathVariable("id") String Id, @RequestBody UserTitleReviews reviews) {
		return userSvc.updateReview(Id, reviews);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void deleteReview(@PathVariable("id") String Id) {
		userSvc.deleteReview(Id);
	}

}
