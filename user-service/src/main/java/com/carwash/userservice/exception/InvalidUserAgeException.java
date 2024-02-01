package com.carwash.userservice.exception;

public class InvalidUserAgeException  extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public InvalidUserAgeException(String message) {
		super(message);
	}
}


