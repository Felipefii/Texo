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
@RequestMapping(value = "/awards")
public class PremiumController {

	@Autowired
	ProducerService producerService;
	
	@Autowired
	MovieService movieService;
	
	/*
	 * @GetMapping public ResponseEntity<IntervalDTO> showAwards(){ IntervalDTO
	 * intervalDto = intervalCalc(); return new
	 * ResponseEntity<IntervalDTO>(intervalDto, HttpStatus.OK); }
	 * 
	 * private IntervalDTO intervalCalc() { List<Movie> movies =
	 * movieService.findAllMoviesWinners();
	 * 
	 * return new IntervalDTO(min, max); }
	 */
	
	@GetMapping
	public ResponseEntity<List<Movie>> buscar(){
		List<Movie> movies = movieService.findAllMoviesWinners(true);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
}
