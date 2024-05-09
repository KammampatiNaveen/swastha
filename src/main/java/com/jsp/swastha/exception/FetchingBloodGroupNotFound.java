package com.jsp.swastha.exception;

import lombok.Data;

@Data
public class FetchingBloodGroupNotFound extends RuntimeException {
	private String msg="Fetching Blood Groups are Empty";

	public FetchingBloodGroupNotFound(String msg) {
		super();
		this.msg = msg;
	}

	public FetchingBloodGroupNotFound() {
		super();
	}
	
	
}
