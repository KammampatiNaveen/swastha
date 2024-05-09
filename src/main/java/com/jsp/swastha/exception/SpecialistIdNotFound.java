package com.jsp.swastha.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class SpecialistIdNotFound extends RuntimeException{

	private String msg="Specialist Id is Not Found";

	public SpecialistIdNotFound() {
		super();
		this.msg = msg;
	}
	
}

