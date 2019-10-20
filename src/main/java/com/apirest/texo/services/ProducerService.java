package com.apirest.texo.services;

import java.util.List;

import com.apirest.texo.entities.Producer;

public interface ProducerService {

	List<Producer> findAll();
	
	Producer findByName(String name);
	
	Producer persist(Producer producer);
	
}
