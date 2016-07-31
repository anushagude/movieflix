package com.netflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.netflix.repository.UserRepository;
import com.netflix.repository.UserTitleReviews;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userrepository;

	@Override
	public List<UserTitleReviews> findAllReviews(){
		return userrepository.findAllReviews();
	}
	@Override
	public UserTitleReviews findOneReview(String userId, String movieId){
		UserTitleReviews userexisting = userrepository.findOneReview(userId,movieId);
		
		return userexisting;
	}
	@Override
	public UserTitleReviews findOne(String id){
    UserTitleReviews userexisting = userrepository.findOne(id);
		
		return userexisting;	
	}
	
	@Override
	@Transactional
	public UserTitleReviews createReview(UserTitleReviews reviews){
		return userrepository.createReview(reviews);
	}
	@Override
	@Transactional
	public UserTitleReviews updateReview(String id, UserTitleReviews reviews){
		return userrepository.updateReview(reviews);
	}
	@Override
	@Transactional
	public void deleteReview(String id){
		UserTitleReviews reviewExist = userrepository.findOne(id);
		
		userrepository.deleteReview(reviewExist);
	}
}
