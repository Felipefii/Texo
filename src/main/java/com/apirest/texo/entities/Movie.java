package com.apirest.texo.entities;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "movie")
public class Movie implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6653545376192952243L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NotNull
	private Integer ano;
	
	@NotNull
	private String title;
	
	@NotNull
	@ManyToMany
	@JoinTable(name="movie_studio",
			joinColumns = {@JoinColumn(name="movie_id")},
			inverseJoinColumns = {@JoinColumn(name = "studio_id")})
	private List<Studio> studios;
	
	@NotNull
	@ManyToMany
	@JoinTable(name="movie_producer", 
		joinColumns = {@JoinColumn(name="movie_id")}, 
		inverseJoinColumns = {@JoinColumn(name = "producer_id")})
	private List<Producer> producers;
	
	private Boolean winner;

	public Movie() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public List<Studio> getStudios() {
		return studios;
	}

	public void setStudios(List<Studio> studios) {
		this.studios = studios;
	}

	public List<Producer> getProducer() {
		return producers;
	}
	
	public void setProducer(List<Producer> producers) {
		this.producers = producers;
	}

	public Boolean getWinner() {
		return winner;
	}

	public void setWinner(Boolean winner) {
		this.winner = winner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
	
	
	
}