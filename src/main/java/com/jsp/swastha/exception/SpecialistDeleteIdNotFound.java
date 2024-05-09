package com.jsp.swastha.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpecialistDeleteIdNotFound extends RuntimeException{

	private String msg="Specialist Delete Id Not Found";
	
}
