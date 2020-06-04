package com.capgemini.hotelbookingmanagementsystem.services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.capgemini.hotelbookingmanagementsystem.bean.Address;
import com.capgemini.hotelbookingmanagementsystem.bean.Customer;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.repository.CustomerRepository;
import com.capgemini.hotelbookingmanagementsystem.repository.HotelRepository;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerServiceImplTest {

	CustomerService customerService = HotelFactory.getCustomerServiceImpl();

	@BeforeAll
	void testRepository() {
		CustomerRepository.customerRepository();
		HotelRepository.hotelRepository();
	}

	@Test
	void testGetRegistrationservice() {
		Address address = new Address("1-2-123/12", "A N Reddy Colony", "Nirmal", "Telangana");
		Customer customer1 = new Customer("Rohit Sharma", 8885544859l, "rohit@gmail.com", 324356456879l, 24,
				"rohit@123", address);
		assertEquals(true, customerService.getRegistrationservice(customer1));
	}

	@Test
	void testGetCustomerLoginService() {
		assertEquals(true, customerService.getCustomerLoginService("dik@gmail.com", "dikshu@123"));
	}

	@Test
	void testGetCustomerNameService() {
		assertEquals("Sachin", customerService.getCustomerNameService("sac@gmail.com", "sachin@123"));
	}

	@Test
	void testGetBookingHotelService() {
		assertEquals(false, customerService.getBookingHotelService(1003));
	}

	@Test
	void testGetHotelService() {
		assertNotNull(customerService.getHotelService(1001));
	}

	@Test
	void testGetBookingRoomService() {

		assertNotNull(customerService.getBookingRoomService(customerService.getHotelService(1001), "taj01",
				LocalDate.now(), LocalDate.of(2020, 12, 22), "dikshith"));
	}

	@Test
	void testGetRoomService() {

		assertEquals(false, customerService.getRoomService(customerService.getHotelService(1001), "taj01"));
	}

	@Test
	void testBookingListService() {
		assertEquals(true, customerService.bookingListService());
	}

	@Test
	void testBookingStatusService() {
		assertNotNull(customerService.bookingStatusService());
	}

	@Test
	void testValidateEmail() {
		assertEquals(true, customerService.validateEmail("dikshith@gmail.com"));
	}

	@Test
	void testValidatePassword() {
		assertEquals(true, customerService.validatePassword("dikshu@123"));
	}

	@Test
	void testValidateName() {
		assertEquals(true, customerService.validateName("Rohit sharma"));
	}

	@Test
	void testValidatePhnno() {
		assertEquals(false, customerService.validatePhnno("98487140"));
	}

	@Test
	void testValidateAdhaarNo() {
		assertEquals(true, customerService.validateAdhaarNo("234876451980"));
	}

	@Test
	void testValidateAge() {
		assertEquals(false, customerService.validateAge("12"));
	}

	@Test
	void testValidateHno() {
		assertEquals(true, customerService.validateHno("1-9-198/12B"));
	}

	@Test
	void testValidateAddress() {
		assertEquals(true, customerService.validateAddress("nirmal"));
	}

	@Test
	void testValidateOption2() {
		assertEquals(false, customerService.validateOption2("7"));
	}

	@Test
	void testValidateDate() {
		assertEquals(true, customerService.validateDate("2020-09-10"));
	}

}
