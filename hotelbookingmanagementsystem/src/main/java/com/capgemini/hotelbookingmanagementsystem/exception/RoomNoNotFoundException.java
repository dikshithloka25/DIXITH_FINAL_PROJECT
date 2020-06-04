package com.capgemini.hotelbookingmanagementsystem.exception;

/**
 * This class is about {@link RoomNoNotFoundException}
 * 
 * @author Dixith Reddy
 *
 */

public class RoomNoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6479971828502439185L;
	final String message = "You Must Enter Room Number From The Given List \n";

	@Override
	public String getMessage() {

		return message;

	}
}
