package com.apirest.texo.services;

import java.util.List;

import com.apirest.texo.entities.Producer;

public interface ProducerService {

	/**
	 * Metodo utilizado para listar todos os produtores 
	 * 
	 * @author Felipe Nazário 
	 * 
	 * @return retorna todos os produtores
	 * 
	 */
	List<Producer> findAll();
	
	
	/**
	 * Metodo utilizado para buscar um produtor por nome
	 * 
	 * @author Felipe Nazário 
	 * @param name
	 * 
	 * @return retorna um produtor especifico
	 * 
	 */
	Producer findByName(String name);
	
	
	/**
	 * Metodo utilizado para persistir um produtor 
	 * 
	 * @author Felipe Nazário 
	 * @param producer
	 * 
	 * @return retorna o produtor persistido
	 * 
	 */
	Producer persist(Producer producer);
	
}
