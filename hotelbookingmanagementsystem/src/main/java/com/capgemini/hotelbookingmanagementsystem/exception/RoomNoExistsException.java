package com.capgemini.hotelbookingmanagementsystem.exception;

/**
 * This class is about {@link RoomNoExistsException}
 * 
 * @author Dixith Reddy
 *
 */

public class RoomNoExistsException extends RuntimeException {

	private static final long serialVersionUID = -1751832822480966904L;
	final String message = "This Room Number Already Exists \n";

	@Override
	public String getMessage() {

		return message;

	}

}
