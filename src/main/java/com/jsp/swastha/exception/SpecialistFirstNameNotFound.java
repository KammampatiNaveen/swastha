package com.jsp.swastha.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpecialistFirstNameNotFound extends RuntimeException{

	private String msg="Specialist First is Not Found";

	
	
}
