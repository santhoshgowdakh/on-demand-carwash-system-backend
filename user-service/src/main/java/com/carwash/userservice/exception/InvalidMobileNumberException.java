package com.carwash.userservice.exception;

public class InvalidMobileNumberException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public InvalidMobileNumberException(String message) {
		super(message);
	}
}