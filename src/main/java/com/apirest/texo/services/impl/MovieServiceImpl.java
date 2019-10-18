package com.apirest.texo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.apirest.texo.entities.Movie;
import com.apirest.texo.repositories.MovieRepository;
import com.apirest.texo.services.MovieService;

public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public Movie persist(Movie movie) {
		movieRepository.save(movie);
		return null;
	}

	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll(); 
	}

}
