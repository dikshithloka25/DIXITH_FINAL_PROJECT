package com.capgemini.hotelbookingmanagementsystem.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * This class is about {@link Room}
 * 
 * @author Admin
 *
 */

public class Room implements Serializable {

	private static final long serialVersionUID = -8143303901858195008L;
	private String roomNo;
	private String roomType;
	private String guestName;
	private double roomPrice;
	private String roomStatus;
	private String[] availabilities;
	private LocalDate from;
	private LocalDate to;

	public Room() {

	}

	public Room(String roomNo, String roomType, String guestName, double roomPrice, String roomStatus,
			String[] availabilities, LocalDate from, LocalDate to) {
		super();
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.guestName = guestName;
		this.roomPrice = roomPrice;
		this.roomStatus = roomStatus;
		this.availabilities = availabilities;
		this.from = from;
		this.to = to;
	}

	public String[] getAvailabilities() {
		return availabilities;
	}

	public void setAvailabilities(String[] availabilities) {
		this.availabilities = availabilities;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public LocalDate getFrom() {
		return from;
	}

	public void setFrom(LocalDate from) {
		this.from = from;
	}

	public LocalDate getTo() {
		return to;
	}

	public void setTo(LocalDate to) {
		this.to = to;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	@Override
	public String toString() {
		return "\nRoom Number=" + roomNo + "            Room Type=" + roomType + "                   Room Price=" + roomPrice
				+ "\nRoom Status=" + roomStatus + "    Availabilities=" + Arrays.toString(availabilities) + "   From="
				+ from + "\nTo=" + to + "\n";
	}

}
