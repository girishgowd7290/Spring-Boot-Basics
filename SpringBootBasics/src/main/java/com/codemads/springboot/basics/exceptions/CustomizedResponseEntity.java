/**
 * 
 */
package com.codemads.springboot.basics.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.codemads.springboot.basics.UserNotFoundException;

/**
 * CustomizedResponseEntity extends ResponseEntityExceptionHandler to make use of Custom messages in Exception
 * 
 * Use @ControllerAdvice & @RestController to enable this class to act as a Rest Interface and to send back error messages 
 * @author girishgowda
 *
 */

@ControllerAdvice
@RestController
public class CustomizedResponseEntity extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(), ex.getMessage(), request.getDescription(false));
		

		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	// this method is called whenever a UserNotFoundException is thrown 
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
		// Used to throw a custom exception by adding values to ExceptionResponse class
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	
	// This is called when a method levle arguemnt fail to satisfy the condition defined 
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(), "validation failed", ex.getBindingResult().toString());
		
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	
}
