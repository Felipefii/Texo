package com.apirest.texo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.texo.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
