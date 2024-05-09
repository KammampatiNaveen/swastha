package com.jsp.swastha.exception;

import lombok.Data;

@Data
public class DeleteIdNotFound extends RuntimeException{

	private String msg="Delete Id is not Found";

	public DeleteIdNotFound(String msg) {
		super();
		this.msg = msg;
	}

	public DeleteIdNotFound() {
		super();
	}
	
	
	
}
