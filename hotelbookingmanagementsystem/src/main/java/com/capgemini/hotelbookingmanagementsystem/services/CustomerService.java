package com.capgemini.hotelbookingmanagementsystem.services;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.hotelbookingmanagementsystem.bean.Customer;
import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;

public interface CustomerService {

	public boolean getRegistrationservice(Customer customer);

	public boolean getCustomerLoginService(String email, String password);

	public String getCustomerNameService(String email, String password);

	public boolean getBookingHotelService(int hotelId);

	public Hotel getHotelService(int hotelId);

	public boolean getRoomService(Hotel hotel, String roomNo);

	public Room getBookingRoomService(Hotel hotel, String roomNo, LocalDate from, LocalDate to, String name);

	public boolean bookingListService();

	public List<Room> bookingStatusService();

	public boolean validateName(String name);

	public boolean validateEmail(String email);

	public boolean validatePassword(String password);

	public boolean validatePhnno(String phnNo);

	public boolean validateAdhaarNo(String adhaar);

	public boolean validateAge(String age);

	public boolean validateHno(String hNo);

	public boolean validateAddress(String address);

	public boolean validateOption2(String option);

	public boolean validateDate(String date);

}
