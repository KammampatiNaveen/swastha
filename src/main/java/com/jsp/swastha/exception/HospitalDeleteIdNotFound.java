package com.jsp.swastha.exception;

import lombok.Data;

@Data
public class HospitalDeleteIdNotFound extends RuntimeException {

	private String msg="Hospital Delete Id Not Found";

	public HospitalDeleteIdNotFound(String msg) {
		super();
		this.msg = msg;
	}

	public HospitalDeleteIdNotFound() {
		super();
	}
	
}
