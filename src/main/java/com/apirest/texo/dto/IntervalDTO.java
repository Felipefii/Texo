package com.apirest.texo.dto;

import java.io.Serializable;

public class IntervalDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4834295495258151389L;
	
	private IntervalImplDTO max;
	private IntervalImplDTO min;
	
	public IntervalDTO(IntervalImplDTO max, IntervalImplDTO min) {
		this.max = max;
		this.min = min;
	}
	
	public IntervalImplDTO getMax() {
		return max;
	}

	public void setMax(IntervalImplDTO max) {
		this.max = max;
	}

	public IntervalImplDTO getMin() {
		return min;
	}

	public void setMin(IntervalImplDTO min) {
		this.min = min;
	}
	
	
	
	
	
}
