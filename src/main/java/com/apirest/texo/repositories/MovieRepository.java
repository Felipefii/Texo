package com.apirest.texo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.texo.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	
	List<Movie> findByWinner(Boolean win);
}
