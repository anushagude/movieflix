package com.netflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netflix.repository.Movie;
import com.netflix.repository.MoviesRepository;

@Component
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	MoviesRepository repository;

	@Override
	public List<Movie> findAll() {
		
		return repository.findAllMovies();
	}
	
	@Override
	
	public Movie findOne(String id) {
		Movie movieexisting = repository.findOneMovie(id);
		
		return movieexisting;
	}
	

//	@Override
//	
//	public User findUser(String id) {
//		User userExist = repository.findUser(id);
//		if (userExist == null) {
//			throw new EmployeeNotFoundException("Employee with id:" + id + " not found");
//		}
//		return userExist;
//	}
	
	@Override
	@Transactional
	public Movie create(Movie movie){
		
		return repository.create(movie);
		
	}
	@Override
	@Transactional
	public Movie update(String id, Movie movie) {
		
		return repository.update(movie);
	}

	@Override
	@Transactional
	public void delete(String id) {
     Movie movieExist = repository.findOneMovie(id);
		
		repository.delete(movieExist);
	}

	@Override
	public List<Movie> findAllAndSort(String sortCol, boolean asc) {
		return repository.findAllAndSort(sortCol, asc);
	}

}
