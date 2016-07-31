package com.netflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<UserTitleReviews> findAllReviews() {
		TypedQuery<UserTitleReviews> query = em.createNamedQuery("UserTitleReviews.findAll", UserTitleReviews.class);

		return query.getResultList();
	}

	@Override
	public UserTitleReviews findOneReview(String userId, String movieId) {
		TypedQuery<UserTitleReviews> query = em.createNamedQuery("UserTitleReviews.findOne", UserTitleReviews.class);
		return query.getSingleResult();
	}

	@Override
	public UserTitleReviews findOne(String id) {
		return em.find(UserTitleReviews.class, id);
		
	}

	@Override
	public UserTitleReviews createReview(UserTitleReviews reviews) {
		em.persist(reviews);
		return reviews;
		
	}

	@Override
	public UserTitleReviews updateReview(UserTitleReviews reviews) {
		
		return em.merge(reviews);
	}

	@Override
	public void deleteReview(UserTitleReviews reviews) {
		 em.remove(reviews);
		
	}

}
