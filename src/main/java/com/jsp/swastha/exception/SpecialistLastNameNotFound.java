package com.jsp.swastha.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpecialistLastNameNotFound extends RuntimeException{

	private String msg="Specialist Last Name is Not Found";
}
