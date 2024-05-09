package com.jsp.swastha.exception;

import lombok.Data;

@Data
public class SpecialistPasswordWrong extends RuntimeException{

	private String msg="Specialist Password is Wrong";

	public SpecialistPasswordWrong(String msg) {
		super();
		this.msg = msg;
	}

	public SpecialistPasswordWrong() {
		super();
	}
	
	
}
