package com.capgemini.hotelbookingmanagementsystem.exception;

/**
 * This class is about {@link DateNotFoundException}.
 * 
 * @author Dixith Reddy
 *
 */

public class DateNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6134283401301061053L;
	final String message = "No Room Booked on Particular Date \n";

	@Override
	public String getMessage() {

		return message;

	}
}
