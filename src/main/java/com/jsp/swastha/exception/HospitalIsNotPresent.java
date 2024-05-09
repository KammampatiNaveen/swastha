package com.jsp.swastha.exception;

import lombok.Data;

@Data
public class HospitalIsNotPresent extends RuntimeException {

	private String msg="Hospital Is Not Present";

	public HospitalIsNotPresent(String msg) {
		super();
		this.msg = msg;
	}

	public HospitalIsNotPresent() {
		super();
	}
	
}
