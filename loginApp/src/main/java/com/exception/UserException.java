package com.exception;

public class UserException extends Exception {// extends is inheritance concept ==is a relation
	private String errorMessage;

	public UserException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	@Override
	public String getMessage() {
		
		return this.errorMessage;
	}

}
