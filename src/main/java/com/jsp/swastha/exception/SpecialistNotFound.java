package com.jsp.swastha.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpecialistNotFound extends RuntimeException{

	private String msg="Provide Proper Specialist Name";
}
