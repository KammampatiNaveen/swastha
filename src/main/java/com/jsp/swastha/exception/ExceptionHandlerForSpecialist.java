package com.jsp.swastha.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.swastha.util.ResponseStructure;


@RestControllerAdvice
public class ExceptionHandlerForSpecialist {
	
	@ExceptionHandler(SpecialistFirstNameNotFound.class)
	public ResponseEntity<ResponseStructure<String>> fetchByFirstName(SpecialistFirstNameNotFound s){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(s.getMsg());
		structure.setMessage("Provide Proper Specialist First Name");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SpecialistLastNameNotFound.class)
	public ResponseEntity<ResponseStructure<String>> fetchByLastName(SpecialistLastNameNotFound s){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(s.getMsg());
		structure.setMessage("Provide Proper Last Name");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ExperienceNotFound.class)
	public ResponseEntity<ResponseStructure<String>> fetchByExperience(ExperienceNotFound e){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(e.getMsg());
		structure.setMessage("Provide Proper Input");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SpecialistNotFound.class)
	public ResponseEntity<ResponseStructure<String>> fetchBySpecialist(SpecialistNotFound s){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(s.getMsg());
		structure.setMessage("Provide Proper Input");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SpecialistAdminNotFound.class)
	public ResponseEntity<ResponseStructure<String>> fetchingAdmin(SpecialistAdminNotFound s){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(s.getMsg());
		structure.setMessage("Provide Proper Input");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SpecialistCityNotFound.class)
	public ResponseEntity<ResponseStructure<String>> fetchingCity(SpecialistCityNotFound c){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(c.getMsg());
		structure.setMessage("Provide Proper Input");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}
