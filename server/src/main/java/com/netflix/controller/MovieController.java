package com.netflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.exception.EntityNotFoundException;
import com.netflix.repository.Movie;
import com.netflix.services.MovieService;

@SpringBootApplication
@ComponentScan({"com.netflix.services","com.netflix.repository"})
@RestController
@RequestMapping(path = "movies")
@EnableJpaRepositories("com.netflix.repository")
@EnableAutoConfiguration
public class MovieController {

	@Autowired
	private MovieService movieSvc;

	public static void main(String[] args) throws Exception {
        SpringApplication.run(new Object[]{MovieController.class, UserController.class}, args);
    }
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findall() {
		return movieSvc.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value="/sort", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findall(@RequestParam("sortby") String sortCol, @RequestParam("sortOrder") String sortOrder) {
		return movieSvc.findAllAndSort(sortCol, "asc".equalsIgnoreCase(sortOrder));
	}	
	
	@RequestMapping(method = RequestMethod.GET, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findOne(@PathVariable("id") String Id) {
		Movie lookedUpVal = movieSvc.findOne(Id);
		if(lookedUpVal == null) {
			throw new EntityNotFoundException(String.format("Movie with id %s not found", Id));
		}
		return lookedUpVal;
	}

	@RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, "application/json"}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, "application/json"})
	public Movie create(@RequestBody Movie movie) {
		return movieSvc.create(movie);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("id") String Id, @RequestBody Movie movie) {
		Movie lookedUpVal = movieSvc.findOne(Id);
		if(lookedUpVal == null) {
			throw new EntityNotFoundException(String.format("Movie with id %s not found for update operation", Id));
		}
		return movieSvc.update(Id, movie);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void delete(@PathVariable("id") String Id) {
		movieSvc.delete(Id);
	}

	public MovieService getMovieSvc() {
		return movieSvc;
	}

	public void setMovieSvc(MovieService movieSvc) {
		this.movieSvc = movieSvc;
	}
	
}
