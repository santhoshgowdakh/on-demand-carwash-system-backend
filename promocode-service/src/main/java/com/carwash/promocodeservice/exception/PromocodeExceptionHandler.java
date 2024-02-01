package com.carwash.promocodeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.carwash.promocodeservice.entity.ResponseMessage;

@ControllerAdvice
public class PromocodeExceptionHandler {

	@ExceptionHandler(value=PromocodeNotFoundException .class)
	public ResponseEntity<ResponseMessage> exception(PromocodeNotFoundException exception){
		ResponseMessage responseMessage=new ResponseMessage();
		responseMessage.setMessage(exception.getMessage());
		return new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=PromocodeAlreadyExistsException .class)
	public ResponseEntity<String> exception(PromocodeAlreadyExistsException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
