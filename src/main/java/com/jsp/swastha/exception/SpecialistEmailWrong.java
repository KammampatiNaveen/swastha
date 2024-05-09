package com.jsp.swastha.exception;

import lombok.Data;

@Data
public class SpecialistEmailWrong extends RuntimeException{

	private String msg="Provide Proper Email";

	public SpecialistEmailWrong(String msg) {
		super();
		this.msg = msg;
	}

	public SpecialistEmailWrong() {
		super();
	}
	
}
