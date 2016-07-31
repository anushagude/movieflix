package com.netflix.repository;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public interface UserRepository {
	
	public List<UserTitleReviews> findAllReviews();

	public UserTitleReviews findOneReview(String userId, String movieId);
	
	public UserTitleReviews findOne(String id);

	public UserTitleReviews createReview(UserTitleReviews reviews);

	public UserTitleReviews updateReview(UserTitleReviews reviews);

	public void deleteReview(UserTitleReviews reviews);

}
