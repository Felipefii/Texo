package com.apirest.texo.services;

import java.util.List;

import com.apirest.texo.entities.Movie;

public interface MovieService {
	
	Movie persist(Movie movie);
	
	List<Movie> findAll();
	
}
