package com.carwash.orderservice.exception;

public class OrderAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderAlreadyExistsException(String message) {
		super(message);
	}
	

}
