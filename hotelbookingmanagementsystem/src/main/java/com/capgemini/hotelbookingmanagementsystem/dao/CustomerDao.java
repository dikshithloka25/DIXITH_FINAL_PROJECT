package com.capgemini.hotelbookingmanagementsystem.dao;

import java.time.LocalDate;
import java.util.*;

import com.capgemini.hotelbookingmanagementsystem.bean.Customer;
import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;

public interface CustomerDao {
	public boolean customerRegistration(Customer customer);

	public boolean login(String email, String password);

	public String getCustomerName(String email, String password);

	public boolean bookingHotel(int hotelId);

	public Hotel getHotel(int hotelId);

	public boolean getRoom(Hotel hotel, String roomNo);

	public Room bookingRoom(Hotel hotel, String roomNo, LocalDate from, LocalDate to, String name);

	public List<Room> bookingStatus();

}
