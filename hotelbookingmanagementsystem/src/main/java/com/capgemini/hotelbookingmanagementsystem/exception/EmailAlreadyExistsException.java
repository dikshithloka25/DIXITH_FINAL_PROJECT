package com.capgemini.hotelbookingmanagementsystem.exception;

/**
 * This class is about {@link EmailAlreadyExistsException}
 * 
 * @author Admin
 *
 */

public class EmailAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1325812179487560923L;
	final String message = "This Email Id Already Exists \n";

	@Override
	public String getMessage() {

		return message;

	}
}
