package com.apirest.texo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.texo.entities.Movie;
import com.apirest.texo.repositories.MovieRepository;
import com.apirest.texo.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public Movie persist(Movie movie) {
		return movieRepository.saveAndFlush(movie);
	}

	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll(); 
	}

	@Override
	public List<Movie> findAllMoviesWinners(Boolean win) {		
		return movieRepository.findByWinner(win);
	}

}