package com.capgemini.hotelbookingmanagementsystem.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.repository.CustomerRepository;
import com.capgemini.hotelbookingmanagementsystem.repository.HotelRepository;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EmployeeManagementServiceImplTest {

	@BeforeAll
	void testRepository() {
		CustomerRepository.customerRepository();
		HotelRepository.hotelRepository();
	}

	@Test
	void testGetEmployeeLogin() {
		assertEquals(true, HotelFactory.getEmployeeManagementService().getEmployeeLoginService(1001,
				"employee@123"));
	}

}
