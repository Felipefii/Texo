package com.apirest.texo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.texo.entities.Producer;
import com.apirest.texo.repositories.ProducerRepository;
import com.apirest.texo.services.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService{

	@Autowired
	ProducerRepository producerRepository;
	
	@Override
	public Producer findByName(String name) {
		return producerRepository.findByName(name);
	}

	@Override
	public Producer persist(Producer producer) {
		return producerRepository.saveAndFlush(producer);
	}

	@Override
	public List<Producer> findAll() {
		
		return producerRepository.findAll();
	}

	
}