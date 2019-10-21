package com.apirest.texo.services;

import java.util.List;

import com.apirest.texo.entities.Movie;


public interface MovieService {
	
	/**
	 * Metodo utilizado para persistir um filme 
	 * 
	 * @author Felipe Nazário 
	 * @param movie
	 * 
	 * @return retorna um filme
	 * 
	 */
	Movie persist(Movie movie);
	
	/**
	 * Metodo utilizado para listar todos os filmes
	 * 
	 * @author Felipe Nazário 
	 * 
	 * @return retorna todos os filmes
	 * 
	 */
	List<Movie> findAll();
	
	/**
	 * Metodo utilizado para listar todos os filmes com true ou false no campo winner
	 * 
	 * @author Felipe Nazário 
	 * @param win
	 * 
	 * @return retorna todos os filmes com winner true ou false
	 * 
	 */
	List<Movie> findAllMoviesWinners(Boolean win);
}
