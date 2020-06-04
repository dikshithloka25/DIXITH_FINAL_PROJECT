package com.capgemini.hotelbookingmanagementsystem.exception;

/**
 * This class is about {@link NoRoomsBookedException}
 * 
 * @author Dixith Reddy
 *
 */

public class NoRoomsBookedException extends RuntimeException {

	private static final long serialVersionUID = 4738149760641038330L;
	final String message = "No Rooms Booked \n";

	@Override
	public String getMessage() {

		return message;

	}

}
