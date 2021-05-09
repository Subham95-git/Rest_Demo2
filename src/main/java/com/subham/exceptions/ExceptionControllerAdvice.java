package com.subham.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.subham.dto.ErrorMessage;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(NoSuchCustomerException.class)
	public ResponseEntity<ErrorMessage> noSuchCustomer(NoSuchCustomerException ex){
		
		ErrorMessage error = new ErrorMessage();
		
		error.setErrorCode(HttpStatus.BAD_GATEWAY.value());
		error.setErrorMessgae(ex.getMessage());
		
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler(ProductNotFoundExecption.class)
	public ResponseEntity<ErrorMessage> noSuchProduct(ProductNotFoundExecption ex){
		
		ErrorMessage error = new ErrorMessage();
		
		error.setErrorCode(HttpStatus.BAD_GATEWAY.value());
		error.setErrorMessgae(ex.getMessage());
		
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.OK);
	}
}
