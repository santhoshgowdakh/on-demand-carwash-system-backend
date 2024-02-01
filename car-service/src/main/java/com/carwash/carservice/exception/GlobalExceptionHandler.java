package com.carwash.carservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = CarNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(Exception exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
}