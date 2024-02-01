package com.carwash.userservice.exception;

public class UserNameAlreadyExistException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public UserNameAlreadyExistException(String message) {
		super(message);
	}
}