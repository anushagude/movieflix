package com.netflix.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "UserTitleReviews.findAll", query = "SELECT e FROM UserTitleReviews e"),
	@NamedQuery(name = "UserTitleReviews.findOne", query = "SELECT e FROM UserTitleReviews e where e.userId = :userId and e.movieId = :movieId")
	 
})
public class UserTitleReviews {

	@Id
	@Column(name = "reviewId")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String reviewId;
	private int rating;
	private String reviews;
	
	private String userId;
	
	private String movieId;
	
	

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	

	@Override
	public String toString() {
		return "UserTitleReviews [rating=" + rating + ", reviews=" + reviews + ", user=" + userId + ", movie=" + movieId
				+ "]";
	}

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	
	
	
}
