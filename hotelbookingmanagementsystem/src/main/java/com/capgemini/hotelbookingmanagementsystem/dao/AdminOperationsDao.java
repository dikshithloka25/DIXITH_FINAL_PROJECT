package com.capgemini.hotelbookingmanagementsystem.dao;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;

public interface AdminOperationsDao {

	public boolean login(String email, String password);

	public boolean addHotel(Hotel hotel);

	public boolean deleteHotel(int hotelId);

	public boolean getHotelId(int hotelId);

	public boolean updateHotel(int hotelId, Hotel hotel);

	public boolean addRoom(int hotelId, Room room);

	public boolean deleteRoom(int hotelId, String roomNo);

	public boolean updateRoom(int hotelId, String roomNo, Room room);

	public boolean getAdminRoom(Hotel hotel, String roomNo);

	public Room getHotelRoom(int hotelId, String roomNo);

	public List<Room> bookingsByDate(LocalDate ld);

	public List<String> hotelGuestName(int hotelId);

	public List<Room> specificHotelBookingList(int hotelId);
}
