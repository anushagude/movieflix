package com.netflix.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.netflix.repository.Movie;

@Component
public interface MovieService {

	public List<Movie> findAll();

	public Movie findOne(String id);
	

	public Movie create(Movie movie);

	public Movie update(String id, Movie movie);

	public void delete(String id);

	public List<Movie> findAllAndSort(String sortCol, boolean asc);
}
