package com.portone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.portone.model.CustomException;
import com.stripe.exception.StripeException;

@ControllerAdvice
public class GlobalExceptionHandler {

	// handling StripeException with custom object
	@ExceptionHandler(StripeException.class)
	public ResponseEntity<CustomException> stripeException(StripeException stripeExp, WebRequest w){
		
		// creating custom exception object for better understanding of error message
		CustomException response = new CustomException(stripeExp.getMessage(),w.getDescription(false));
		
		// returning response with bad gateway
		return new ResponseEntity<>(response,HttpStatus.BAD_GATEWAY);
		
	}
	
	// handling global exception super class Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomException> Exception(Exception exp, WebRequest w){
		
		// creating custom exception object for better understanding of error message
		CustomException response = new CustomException(exp.getMessage(),w.getDescription(false));
		
		// returning response with bad gateway
		return new ResponseEntity<>(response,HttpStatus.BAD_GATEWAY);
		
	}
	
	
}
