package com.apirest.texo.services;

import java.util.List;

import com.apirest.texo.entities.Movie;
import com.apirest.texo.entities.Producer;


public interface MovieService {
	
	Movie persist(Movie movie);
	
	List<Movie> findAll();
	
	List<Movie> findByProducerAndWinner(Producer producer);
}
