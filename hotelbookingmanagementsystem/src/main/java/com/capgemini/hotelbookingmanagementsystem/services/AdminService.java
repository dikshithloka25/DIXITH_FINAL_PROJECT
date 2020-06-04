package com.capgemini.hotelbookingmanagementsystem.services;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;

public interface AdminService {

	public boolean getAdminLoginService(String email, String password);

	public boolean getAddHotelService(Hotel hotel);

	public boolean getDeleteHotelService(int hotelId);

	public boolean getHotelIdService(int hotelId);

	public boolean getUpdateHotelService(int hotelId, Hotel hotel);

	public boolean getAddRoomService(int hotelId, Room room);

	public boolean getDeleteRoomService(int hotelId, String roomNo);

	public boolean getUpdateRoomService(int hotelId, String roomNo, Room room);

	public Room getRoomService(int hotelId, String roomNo);

	public boolean getAdminRoomService(Hotel hotel, String roomNo);

	public List<Room> getSpecificHotelService(int hotelId);

	public List<String> getGuestNameService(int hotelId);

	public List<Room> getByDateService(LocalDate date);

	public boolean validateHotelId(String hotelId);

	public boolean validateHotelName(String hotelName);

	public boolean validateHotelDescription(String description);

	public boolean validateHotelAddress(String address);

	public boolean validateRoomNo(String roomNo);

	public boolean validateRoomPrice(String roomPrice);

	public boolean validateOption3(String option);

	public String validateRoomType(int option);

	public String validateRoomStatus(int option);

	public String validateAvailabilities(int option);

	public boolean validateOption1(String option);
}
