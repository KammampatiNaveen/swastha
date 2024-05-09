package com.jsp.swastha.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.swastha.util.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandlerForHospital {

	@ExceptionHandler(HospitalUpdateIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> updateIdNotFound(HospitalUpdateIdNotFound h){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(h.getMsg());
		structure.setMessage("Provide Proper Input");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HospitalDeleteIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> deleteIdNotFound(HospitalDeleteIdNotFound d){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(d.getMsg());
		structure.setMessage("Hospital Delete Id Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HospitalIsNotPresent.class)
	public ResponseEntity<ResponseStructure<String>> hospitalNotPresent(HospitalIsNotPresent h){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(h.getMsg());
		structure.setMessage("Hospital Is Not Present");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}
