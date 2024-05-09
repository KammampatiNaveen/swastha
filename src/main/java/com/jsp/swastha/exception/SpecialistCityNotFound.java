package com.jsp.swastha.exception;

import lombok.Data;

@Data
public class SpecialistCityNotFound extends RuntimeException {

	private String msg="City Not Found";

	public SpecialistCityNotFound(String msg) {
		super();
		this.msg = msg;
	}

	public SpecialistCityNotFound() {
		super();
	}
	
	
}
