package com.carwash.planservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlanExceptionHandler {

	@ExceptionHandler(value=PlanNotFoundException .class)
	public ResponseEntity<String> exception(PlanNotFoundException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=PlanAlreadyExistsException .class)
	public ResponseEntity<String> exception(PlanAlreadyExistsException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
