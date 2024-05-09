package com.jsp.swastha.exception;

import lombok.Data;

@Data
public class HospitalUpdateIdNotFound extends RuntimeException {

	private String msg="Hospital Update Id Not Found";

	public HospitalUpdateIdNotFound(String msg) {
		super();
		this.msg = msg;
	}

	public HospitalUpdateIdNotFound() {
		super();
	}
	
	
}
