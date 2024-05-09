package com.jsp.swastha.exception;

import lombok.Data;

@Data
public class UserIdNotFound extends RuntimeException{

	private String msg="User Id Is Not Found";

	public UserIdNotFound(String msg) {
		super();
		this.msg = msg;
	}

	public UserIdNotFound() {
		super();
	}
	
	
}
