package com.apirest.texo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.texo.entities.Movie;
import com.apirest.texo.services.MovieService;
import com.apirest.texo.services.ProducerService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	@Autowired
	MovieService movieService;
	@Autowired
	ProducerService producerService;

	/**
	 * Metodo utilizado para retornar dados à requisição get
	 * buscando por todos os filmes salvos na base de dados 
	 * 
	 * pode ser acessado por meio do link
	 * http://localhost:8080/movies
	 * 
	 * @author Felipe Nazário 
	 * 
	 * @return retorna todos os filmes
	 * 
	 */	
	@GetMapping 
	public ResponseEntity<List<Movie>> findAllMovies(){
	 
		List<Movie> movies = movieService.findAll();
		if(movies.isEmpty()) { return
				new ResponseEntity<List<Movie>>(movies, HttpStatus.NOT_FOUND); 
		} 
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	
	}
	

}
