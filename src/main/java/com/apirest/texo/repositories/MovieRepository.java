package com.apirest.texo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.jpa.repository.Query;*/

import com.apirest.texo.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	/* @Query("SELECT m FROM Movie m WHERE m.winner = true") */
	List<Movie> findByWinner(Boolean win);
}
