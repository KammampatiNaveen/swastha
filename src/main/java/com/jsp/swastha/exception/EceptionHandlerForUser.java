package com.jsp.swastha.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.swastha.util.ResponseStructure;



@RestControllerAdvice
public class EceptionHandlerForUser {
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> sqlexception(SQLIntegrityConstraintViolationException e){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(e.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setMessage("You can't perform this operation");
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(PasswordWrongException.class)
	public ResponseEntity<ResponseStructure<String>> passwordWrong(PasswordWrongException e){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(e.getMsg());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("password is wrong");
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(EmailWrongException.class)
	public ResponseEntity<ResponseStructure<String>> emailWrong(EmailWrongException e){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(e.getMsg());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("entered the wrong email");
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(UserIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> userIdNotFound(UserIdNotFound u){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(u.getMsg());
		structure.setMessage("User Id Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DeleteIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> deleteIdNotFound(DeleteIdNotFound d){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(d.getMsg());
		structure.setMessage("User Delete Id Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserUpdateIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> updateIdNotFound(UserUpdateIdNotFound u){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(u.getMsg());
		structure.setMessage("User Update Id Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(SpecialistPasswordWrong.class)
	public ResponseEntity<ResponseStructure<String>> passwordWrong(SpecialistPasswordWrong p){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(p.getMsg());
		structure.setMessage("Provide Proper Password");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SpecialistEmailWrong.class)
	public ResponseEntity<ResponseStructure<String>> emailWrong(SpecialistEmailWrong e){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(e.getMsg());
		structure.setMessage("Provide Proper Email");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SpecialistDeleteIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> deleteId(SpecialistDeleteIdNotFound e){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(e.getMsg());
		structure.setMessage("Provide Proper Specialist Delete Id");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SpecialistIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> specialistIdNotFound(SpecialistIdNotFound i){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(i.getMsg());
		structure.setMessage("Specialist Id Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SpecialistUpdateIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> specialistUpdateId(SpecialistUpdateIdNotFound u){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(u.getMsg());
		structure.setMessage("Provide Proper Update Id");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

}
