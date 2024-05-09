package com.jsp.swastha.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExperienceNotFound extends RuntimeException{

	private String msg="Provide Proper Input (or)\n Correct Experience";
}
