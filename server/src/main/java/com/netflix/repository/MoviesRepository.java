package com.netflix.repository;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public interface MoviesRepository {

	public List<Movie> findAllMovies();

	public Movie findOneMovie(String id);

	//public User findByEmail(String email);

	public Movie create(Movie movie);

	public Movie update(Movie movie);

	public void delete(Movie movie);

	public List<Movie> findAllAndSort(String sortCol, boolean asc);
}
