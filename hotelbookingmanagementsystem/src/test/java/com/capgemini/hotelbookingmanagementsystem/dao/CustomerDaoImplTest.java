package com.capgemini.hotelbookingmanagementsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.capgemini.hotelbookingmanagementsystem.bean.Address;
import com.capgemini.hotelbookingmanagementsystem.bean.Customer;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.repository.CustomerRepository;
import com.capgemini.hotelbookingmanagementsystem.repository.HotelRepository;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerDaoImplTest {

	CustomerDao customerDao = HotelFactory.getCustomerDaoImpl();

	@BeforeAll
	void testRepository() {
		CustomerRepository.customerRepository();
		HotelRepository.hotelRepository();
	}

	@Test
	void testCustomerRegistration() {
		Address address = new Address("1-2-123/12", "A N Reddy Colony", "Nirmal", "Telangana");
		Customer customer1 = new Customer("Rohit Sharma", 8885544859l, "rohit@gmail.com", 324356456879l, 24,
				"rohit@123", address);
		assertEquals(true, customerDao.customerRegistration(customer1));
	}

	@Test
	void testLogin() {

		assertEquals(true, customerDao.login("dik@gmail.com", "dikshu@123"));
	}

	@Test
	void testGetCustomerName() {
		assertEquals("dikshith", customerDao.getCustomerName("dik@gmail.com", "dikshu@123"));
	}

	@Test
	void testBookingHotel() {
		assertEquals(true, customerDao.bookingHotel(1001));
	}

	@Test
	void testGetHotel() {

		assertNotNull(customerDao.getHotel(1001));
	}

	@Test
	void testBookingRoom() {

		assertNotNull(customerDao.bookingRoom(customerDao.getHotel(1001), "taj01", null, null, "dikshith"));
	}

	@Test
	void testGetRoom() {

		assertEquals(true, customerDao.getRoom(customerDao.getHotel(1001), "taj01"));
	}

	@Test
	void testBookingStatus() {

		assertNotNull(customerDao.bookingStatus());
	}

}
