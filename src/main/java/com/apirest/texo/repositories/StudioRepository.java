package com.apirest.texo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.texo.entities.Studio;

public interface StudioRepository extends JpaRepository<Studio, Long> {

	Studio findByName(String name);
	
}
