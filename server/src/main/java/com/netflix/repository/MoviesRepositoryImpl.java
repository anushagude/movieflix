package com.netflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

@Repository
public class MoviesRepositoryImpl implements MoviesRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Movie> findAllMovies(){
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		
		return query.getResultList();
	}

	@Override
	public Movie findOneMovie(String id){
		return em.find(Movie.class, id);
	}

	@Override
	public Movie create(Movie movie){		
		em.persist(movie);
		return movie;
	}
	
	@Override
	public Movie update(Movie movie){
		return em.merge(movie);
	}
	
	@Override
	public void delete(Movie movie){
		em.remove(movie);
	}

	@Override
	public List<Movie> findAllAndSort(String sortCol, boolean asc) {
		Session session = em.unwrap(Session.class);
		Criteria c = session.createCriteria(Movie.class);
		c.createAlias("ratings", "rtg");
		sortCol = sortCol.replaceAll("ratings", "rtg");
		if(asc) {
			c.addOrder(Order.asc(sortCol));	
		} else {
			c.addOrder(Order.desc(sortCol));
		}
		
		return c.list();
	}
}
