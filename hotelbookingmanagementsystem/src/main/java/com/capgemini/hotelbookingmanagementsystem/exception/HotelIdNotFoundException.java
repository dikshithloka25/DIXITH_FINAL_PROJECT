package com.capgemini.hotelbookingmanagementsystem.exception;

/**
 * This class is about {@link HotelIdNotFoundException}
 * 
 * @author Admin
 *
 */

public class HotelIdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5868851290836723814L;
	final String message = "You Must Enter Hotel Id from the Given List of Hotels \n ";

	@Override
	public String getMessage() {
		return message;
	}
}
