package com.jsp.swastha.exception;

import lombok.Data;

@Data
public class UserUpdateIdNotFound extends RuntimeException{

	private String msg="User Update ID is not Found";

	public UserUpdateIdNotFound(String msg) {
		super();
		this.msg = msg;
	}

	public UserUpdateIdNotFound() {
		super();
	}
	
	
}
