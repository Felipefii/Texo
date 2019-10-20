package com.apirest.texo.dto;


public class IntervalImplDTO {

	String producer;
	Integer interval;
	Integer previous;
	Integer followingWin;
	
	
	public IntervalImplDTO(String producer, Integer interval, Integer previous, Integer followingWin) {
		this.producer = producer;
		this.interval = interval;
		this.previous = previous;
		this.followingWin = followingWin;
	}
	public IntervalImplDTO() {
		
	}


	public String getProducer() {
		return producer;
	}


	public void setProducer(String producer) {
		this.producer = producer;
	}


	public Integer getInterval() {
		return interval;
	}


	public void setInterval(Integer interval) {
		this.interval = interval;
	}


	public Integer getPrevious() {
		return previous;
	}


	public void setPrevious(Integer previous) {
		this.previous = previous;
	}


	public Integer getFollowingWin() {
		return followingWin;
	}


	public void setFollowingWin(Integer followingWin) {
		this.followingWin = followingWin;
	}
	
	
	
}
