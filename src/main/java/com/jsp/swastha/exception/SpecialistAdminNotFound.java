package com.jsp.swastha.exception;

import lombok.Data;

@Data
public class SpecialistAdminNotFound extends RuntimeException {

	private String msg="Specialist Admin Not Found";

	public SpecialistAdminNotFound(String msg) {
		super();
		this.msg = msg;
	}

	public SpecialistAdminNotFound() {
		super();
	}
	
	
}
