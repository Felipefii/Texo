package com.apirest.texo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.texo.dto.IntervalDTO;
import com.apirest.texo.dto.IntervalImplDTO;
import com.apirest.texo.entities.Movie;
import com.apirest.texo.entities.Producer;
import com.apirest.texo.services.MovieService;
import com.apirest.texo.services.ProducerService;

@RestController
@RequestMapping(value = "/awards")
public class PremiumController {

	@Autowired
	ProducerService producerService;
	
	@Autowired
	MovieService movieService;
	
	@GetMapping
	public ResponseEntity<IntervalDTO> showAwards(){
		IntervalDTO intervalDto = intervalCalc();
		return new ResponseEntity<IntervalDTO>(intervalDto, HttpStatus.OK);
	}

	private IntervalDTO intervalCalc() {
		List<Movie> movies;
		List<Producer> producers = producerService.findAll();
		List<IntervalImplDTO> maiores = new ArrayList<IntervalImplDTO>();
		List<IntervalImplDTO> menores = new ArrayList<IntervalImplDTO>();
		
		for(Producer producer: producers) {
			int biggerInterval = 0;
			int smallerInterval = 5000;
			Integer yearPreviousMax = 0;
			Integer yearFollowingWinMax = 0;
			Integer yearPreviousMin = 0;
			Integer yearFollowingWinMin = 0;
			
			movies = movieService.findByProducerAndWinner(producer);
			
			if(!movies.isEmpty() && movies.size() > 1) {
				
				for(int i=1;i<movies.size();i++) {
					if(movies.get(i).getAno() - movies.get(i-1).getAno() > biggerInterval) {
						biggerInterval = movies.get(i).getAno() - movies.get(i-1).getAno();
						yearPreviousMax = movies.get(i-1).getAno();
						yearFollowingWinMax = movies.get(i).getAno();
					}
					if(movies.get(i).getAno() - movies.get(i-1).getAno() < smallerInterval) {
						smallerInterval = movies.get(i).getAno() - movies.get(i-1).getAno();
						yearPreviousMin = movies.get(i-1).getAno();
						yearFollowingWinMin = movies.get(i).getAno();
					}
				}
				maiores.add(new IntervalImplDTO(producer.getName(), biggerInterval, yearPreviousMax, yearFollowingWinMax));
				menores.add(new IntervalImplDTO(producer.getName(), smallerInterval, yearPreviousMin, yearFollowingWinMin));			
			}			
		}
		int maior = 0;
		int menor = 5000;
		IntervalImplDTO max = new IntervalImplDTO();
		IntervalImplDTO min = new IntervalImplDTO();
		for(IntervalImplDTO m: maiores) {
			if(m.getInterval() > maior) {
				maior = m.getInterval();
				max = m;
			}
		}
		for(IntervalImplDTO m: menores) {
			if(m.getInterval() < menor) {
				menor = m.getInterval();
				min = m;
			}
		}
		
		return new IntervalDTO(min, max);
	}
	
}
