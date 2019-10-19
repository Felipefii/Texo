package com.apirest.texo.services;

import com.apirest.texo.entities.Producer;

public interface ProducerService {
		
	Producer findByName(String name);
	
	Producer persist(Producer producer);
	
}
