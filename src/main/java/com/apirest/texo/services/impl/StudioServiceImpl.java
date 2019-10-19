package com.apirest.texo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.texo.entities.Studio;
import com.apirest.texo.repositories.StudioRepository;
import com.apirest.texo.services.StudioService;

@Service
public class StudioServiceImpl implements StudioService{

	@Autowired
	StudioRepository studioRepository;
	
	@Override
	public Studio findByName(String name) {
		
		return studioRepository.findByName(name);
	}

}
