package com.netflix.services;

import java.util.List;

import org.springframework.stereotype.Component;


import com.netflix.repository.UserTitleReviews;
@Component
public interface UserService {

public List<UserTitleReviews> findAllReviews();

public UserTitleReviews findOneReview(String userId, String movieId);
// public User findUser(String id);

public UserTitleReviews createReview(UserTitleReviews reviews);

public UserTitleReviews updateReview(String id, UserTitleReviews reviews);

public void deleteReview(String id);

public UserTitleReviews findOne(String id);
}
