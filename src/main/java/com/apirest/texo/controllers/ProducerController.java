package com.apirest.texo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.texo.entities.Producer;
import com.apirest.texo.services.ProducerService;

@RestController
@RequestMapping(value = "/producers")
public class ProducerController {

	@Autowired
	ProducerService producerService;
	
	/**
	 * Metodo utilizado para retornar dados à requisição get
	 * buscando por todos os produtores salvos na base de dados 
	 * 
	 * pode ser acessado por meio do link
	 * http://localhost:8080/producers
	 * 
	 * @author Felipe Nazário 
	 *  
	 * @return retorna todos os produtores
	 * 
	 */	
	
	@GetMapping
	public ResponseEntity<List<Producer>> findAllProducers(){
		
		List<Producer> producers = producerService.findAll();
		return new ResponseEntity<List<Producer>>(producers, HttpStatus.OK);
		
	}
	
}
