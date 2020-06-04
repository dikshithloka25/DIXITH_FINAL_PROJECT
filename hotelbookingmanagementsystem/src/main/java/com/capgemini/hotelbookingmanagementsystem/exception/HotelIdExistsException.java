package com.capgemini.hotelbookingmanagementsystem.exception;

/**
 * This class is about {@link HotelIdExistsException}
 * 
 * @author Admin
 *
 */

public class HotelIdExistsException extends RuntimeException {

	private static final long serialVersionUID = -8998013846833192307L;
	final String message = "This HotelId Already Exists \n";

	@Override
	public String getMessage() {

		return message;

	}
}
