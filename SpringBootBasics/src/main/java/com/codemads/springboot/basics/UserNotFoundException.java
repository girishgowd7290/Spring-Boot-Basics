/**
 * 
 */
package com.codemads.springboot.basics;

/**
 * 
 * UserNotFoundException - Custom exception class created to throw exception when user is not found
 * 
 * @author girishgowda
 *
 */
public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
	}

	
}

