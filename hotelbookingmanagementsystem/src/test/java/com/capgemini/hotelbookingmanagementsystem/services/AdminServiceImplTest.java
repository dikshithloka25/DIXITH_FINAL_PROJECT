package com.capgemini.hotelbookingmanagementsystem.services;

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
class AdminServiceImplTest {
	AdminService adminService = HotelFactory.getAdminService();

	@BeforeAll
	void testRepository() {
		CustomerRepository.customerRepository();
		HotelRepository.hotelRepository();
	}

	@Test
	void testGetAdminLoginService() {
		assertEquals(true, adminService.getAdminLoginService("admin@gmail.com", "admin@123"));
	}

	@Test
	void testGetAddHotelService() {
		Hotel hotel = new Hotel(1003, "sreeja hotel", 0, "5* hotel", "nirmal","sreeja@123");
		assertEquals(true, adminService.getAddHotelService(hotel));
	}

	@Test
	void testGetDeleteHotelService() {
		assertEquals(true, adminService.getDeleteHotelService(1002));
	}

	@Test
	void testGetUpdateHotelService() {
		Hotel hotel = new Hotel(1004, "sreeja hotel", 0, "5* hotel", "nirmal","sreeja@123");
		assertEquals(true, adminService.getUpdateHotelService(1001, hotel));
	}

	@Test
	void testGetAddRoomService() {
		String[] s2 = { "FREE WIFI", "NON-A/C", "TV" };
		Room room1 = new Room("myu04", "Double bedroom", null, 1800, "available", s2, null, null);
		assertEquals(true, adminService.getAddRoomService(1001, room1));
	}

	@Test
	void testGetDeleteRoomService() {
		assertEquals(false, adminService.getDeleteRoomService(1001, "taj01"));
	}

	@Test
	void testGetUpdateRoomService() {
		String[] s2 = { "FREE WIFI", "NON-A/C", "TV" };
		Room room1 = new Room("taj04", "Double bedroom", null, 1800, "available", s2, null, null);
		assertEquals(true, adminService.getUpdateRoomService(1001, "taj02", room1));
	}

	@Test
	void testGetRoomService() {
		assertNotNull(adminService.getRoomService(1001, "taj03"));
	}

	@Test
	void testGetHotelIdService() {
		assertEquals(true, adminService.getHotelIdService(1001));
	}

	@Test
	void testGetSpecificHotelService() {
		assertNotNull(adminService.getSpecificHotelService(1001));
	}

	@Test
	void testGetGuestNameService() {
		assertNotNull(adminService.getGuestNameService(1001));
	}

	@Test
	void testGetByDateService() {
		assertNotNull(adminService.getByDateService(LocalDate.now()));
	}

	@Test
	void testValidateHotelId() {
		assertEquals(true, adminService.validateHotelId("1001"));
	}

	@Test
	void testValidateHotelName() {
		assertEquals(true, adminService.validateHotelName("sreeja hotel"));
	}

	@Test
	void testValidateHotelDescription() {
		assertEquals(true, adminService.validateHotelDescription("5* hotel"));
	}

	@Test
	void testValidateHotelAddress() {
		assertEquals(true, adminService.validateHotelAddress("nirmal,telangana"));
	}

	@Test
	void testValidateRoomNo() {
		assertEquals(true, adminService.validateRoomNo("taj02"));
	}

	@Test
	void testValidateRoomPrice() {
		assertEquals(true, adminService.validateRoomPrice("1200"));
	}

	@Test
	void testValidateOption3() {
		assertEquals(true, adminService.validateOption3("3"));
	}

	@Test
	void testValidateRoomType() {
		assertEquals("Double bedroom", adminService.validateRoomType(2));
	}

	@Test
	void testValidateRoomStatus() {
		assertEquals("available", adminService.validateRoomStatus(1));
	}

	@Test
	void testValidateAvailabilities() {
		assertEquals("TV", adminService.validateAvailabilities(2));
	}

	@Test
	void testValidateOption1() {
		assertEquals(true, adminService.validateOption1("1"));
	}

}
