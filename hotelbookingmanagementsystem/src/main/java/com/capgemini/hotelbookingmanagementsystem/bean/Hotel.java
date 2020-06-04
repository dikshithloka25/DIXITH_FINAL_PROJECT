package com.capgemini.hotelbookingmanagementsystem.bean;

import java.io.Serializable;

/**
 * This class is about {@link Hotel}
 * 
 * @author Admin
 *
 */

public class Hotel implements Serializable {

	private static final long serialVersionUID = -323813673591881352L;
	private int hotelId;
	private String hotelName;
	private int noOfRooms;
	private String description;
	private String hotelAddress;
	private String password;

	public Hotel() {
		super();
	}

	

	public Hotel(int hotelId, String hotelName, int noOfRooms, String description, String hotelAddress,
			String password) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.noOfRooms = noOfRooms;
		this.description = description;
		this.hotelAddress = hotelAddress;
		this.password = password;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	@Override
	public String toString() {
		return "\nHotel Id=" + hotelId + "\nHotel Name=" + hotelName + "\nNumber Of Rooms=" + noOfRooms + "\nDescription="
				+ description + "\nhotel Address=" + hotelAddress + "\n";
	}

}
