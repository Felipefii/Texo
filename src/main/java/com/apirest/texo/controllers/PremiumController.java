package com.apirest.texo.controllers;

import java.util.ArrayList;
import java.util.Comparator;
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
import com.apirest.texo.services.ProducerService;

@RestController
@RequestMapping(value = "/awards")
public class PremiumController {

	@Autowired
	ProducerService producerService;
	
	
	/**
	 * Metodo Get para o trabalho - 
	 * Por meio de todos os filmes vencedores do prêmio para cada produtor
	 * são calculados os intervalos de tempo em anos entre dois prêmios seguidos
	 * os objetos são guardados em lista e é retornado apenas o produtor com maior
	 * e o produtor com o menor intervalo.   
	 * 
	 * Pode ser acessado por meio do link
	 * http://localhost:8080/awards
	 * 
	 * @author Felipe Nazário 
	 *  
	 * @return retorna um objeto IntervalDTO com os dados específicos
	 * dos produtores com maior e menor intervalor entre dois prêmios 
	 * 
	 */
	
	@GetMapping
	public ResponseEntity<IntervalDTO> findProducerAwards() {
		
		List<Producer> producers = producerService.findAll();
		if(producers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<Movie> movies;
		List<IntervalImplDTO> iidto = new ArrayList<IntervalImplDTO>();
		List<Movie> winnersMovies;
		for(Producer producer: producers) {
			winnersMovies = new ArrayList<>();
			movies = producer.getMovies();
			movies.sort(Comparator.comparing(Movie::getAno));
			
			  for(Movie movie: movies) { 
				  if(movie.getWinner() == true) {
					  winnersMovies.add(movie); 
				  } 
			  }
			 
			
			if(winnersMovies.size() > 1 && !winnersMovies.isEmpty()) {
				for(int i = 1; i < winnersMovies.size(); i++) {						
						iidto.add(new IntervalImplDTO(
								producer.getName(),
								winnersMovies.get(i).getAno() - winnersMovies.get(i-1).getAno(), 
								winnersMovies.get(i-1).getAno(), 
								winnersMovies.get(i).getAno()));					
				}
			}
		}
		iidto.sort(Comparator.comparing(IntervalImplDTO::getInterval));
		IntervalDTO intervalDTO = new IntervalDTO(iidto.get(iidto.size()-1), iidto.get(0));
		
		return new ResponseEntity<IntervalDTO>(intervalDTO, HttpStatus.OK);
	}
	
	
}
