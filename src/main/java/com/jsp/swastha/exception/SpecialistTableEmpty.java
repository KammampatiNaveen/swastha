package com.jsp.swastha.exception;

import lombok.Data;

@Data
public class SpecialistTableEmpty extends RuntimeException {

	private String msg="Specialist Table is Empty";

	public SpecialistTableEmpty(String msg) {
		super();
		this.msg = msg;
	}

	public SpecialistTableEmpty() {
		super();
	}
	
	
}
