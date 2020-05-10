/**
 * 
 */
package com.codemads.springboot.basics.exceptions;

/**
 * 
 * ExceptionResponse bean is a custom bean written to send the custom exception message
 * @author girishgowda
 *
 */
import java.util.Date;

public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String details;

	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
