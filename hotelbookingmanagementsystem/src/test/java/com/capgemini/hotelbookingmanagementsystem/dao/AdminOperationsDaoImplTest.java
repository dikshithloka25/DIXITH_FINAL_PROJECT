package com.capgemini.hotelbookingmanagementsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.repository.CustomerRepository;
import com.capgemini.hotelbookingmanagementsystem.repository.HotelRepository;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AdminOperationsDaoImplTest {
	AdminOperationsDao adminOperation = HotelFactory.getAdminOperationsDaoImpl();

	@BeforeAll
	void testRepository() {
		CustomerRepository.customerRepository();
		HotelRepository.hotelRepository();
	}

	@Test
	void testLogin() {
		assertEquals(true, adminOperation.login("admin@gmail.com", "admin@123"));
	}

	@Test
	void testAddHotel() {

		Hotel hotel = new Hotel(1003, "sreeja hotel", 0, "5* hotel", "nirmal","sreeja@123");
		assertEquals(true, adminOperation.addHotel(hotel));
	}

	@Test
	void testDeleteHotel() {
		assertEquals(true, adminOperation.deleteHotel(1001));
	}

	@Test
	void testGetHotelId() {
		assertEquals(true, adminOperation.getHotelId(1002));
	}

	@Test
	void testUpdateHotel() {
		Hotel hotel = new Hotel(1003, "sreeja hotel", 0, "5* hotel", "nirmal","sreeja@123");
		assertEquals(true, adminOperation.updateHotel(1002, hotel));
	}

	@Test
	void testAddRoom() {
		String[] s2 = { "FREE WIFI", "NON-A/C", "TV" };
		Room room1 = new Room("myu04", "Double bedroom", null, 1800, "available", s2, null, null);
		assertEquals(true, adminOperation.addRoom(1002, room1));
	}

	@Test
	void testDeleteRoom() {
		assertEquals(false, adminOperation.deleteRoom(1005, "taj01"));
	}

	@Test
	void testUpdateRoom() {
		String[] s2 = { "FREE WIFI", "NON-A/C", "TV" };
		Room room1 = new Room("myu05", "Double bedroom", null, 1800, "available", s2, null, null);
		assertEquals(true, adminOperation.updateRoom(1002, "myu02", room1));
	}

	@Test
	void testBookingsByDate() {

		assertNotNull(adminOperation.bookingsByDate(LocalDate.now()));
	}

	@Test
	void testHotelGuestName() {
		assertNotNull(adminOperation.hotelGuestName(1002));
	}

	@Test
	void testSpecificHotelBookingList() {
		assertNotNull(adminOperation.specificHotelBookingList(1002));
	}

}
