package com.apirest.texo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apirest.texo.entities.Movie;
import com.apirest.texo.entities.Producer;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	@Query(value = "select * from movie m " + 
			"join movie_producer mp on mp.movie_id = m.id " + 
			"join producer p on p.id = mp.producer_id " +
			"where p.name = ?1 " + 
			"and winner = '1' " + 
			"order by p.name", nativeQuery = true)
	List<Movie> findByProducerAndWinnerOrderByAno(Producer producer);
}
