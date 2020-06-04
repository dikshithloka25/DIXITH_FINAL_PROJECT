package com.capgemini.hotelbookingmanagementsystem.validations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;

class ValidationsImplTest {
	Validations inputValidation = HotelFactory.getValidations();

	@Test
	@DisplayName("CustomerName")
	void testCustomerName() {

		assertEquals(true, inputValidation.customerName("Dikshith"));
	}

	@Test
	@DisplayName("CustomerAddress")
	void testCustomerAddress() {

		assertEquals(true, inputValidation.customerAddress("A N Reddy Colony"));
	}

	@Test
	@DisplayName("CustomerPhnno")
	void testCustomerPhno() {

		assertEquals(true, inputValidation.customerPhnno("9505514745"));
	}

	@Test
	@DisplayName("CustomerEmail")
	void testCustomerEmail() {

		assertEquals(true, inputValidation.customerEmail("dikshith@gmail.com"));
	}

	@Test
	@DisplayName("CustomerAdhaar")
	void testCustomerAdhaar() {

		assertEquals(true, inputValidation.customerAdhaar("284781679201"));
	}

	@Test
	@DisplayName("CustomerAge")
	void testCustomerAge() {

		assertEquals(true, inputValidation.customerAge("24"));
	}

	@Test
	@DisplayName("CustomerPassword")
	void testCustomerPassword() {

		assertEquals(true, inputValidation.customerPassword("Dikshu@123"));
	}

	@Test
	@DisplayName("CustomerHNo")
	void testCustomerHNo() {

		assertEquals(true, inputValidation.customerHNo("1-4-136/98"));
	}

	@Test
	@DisplayName("Option1")
	void testOption1() {

		assertEquals(true, inputValidation.option1("2"));
	}

	@Test
	@DisplayName("Option2")
	void testOption2() {

		assertEquals(true, inputValidation.option2("1"));
	}

	@Test
	@DisplayName("Option3")
	void testOption3() {

		assertEquals(true, inputValidation.option3("3"));
	}

	@Test
	@DisplayName("HotelID")
	void testHotelID() {

		assertEquals(true, inputValidation.hotelId("1001"));
	}

	@Test
	@DisplayName("HotelName")
	void testHotelName() {

		assertEquals(true, inputValidation.hotelName("Santhosh DABA"));
	}

	@Test
	@DisplayName("HotelDescription")
	void testHotelDesc() {

		assertEquals(true, inputValidation.hotelDescription("5* hotel"));
	}

	@Test
	@DisplayName("HotelAddress")
	void testHotelAddress() {

		assertEquals(true, inputValidation.hotelAddress("Baswangudi bangalore"));
	}

	@Test
	@DisplayName("RoomNumber")
	void testRoomNumber() {

		assertEquals(true, inputValidation.roomNumber("taj09"));
	}

	@Test

	@DisplayName("RoomType")
	void testRoomType() {
		assertEquals("Single bedroom", inputValidation.roomType(1));
	}

	@Test
	@DisplayName("RoomPrice")
	void testRoomPrice() {

		assertEquals(true, inputValidation.roomPrice("1800"));
	}

	@Test

	@DisplayName("RoomStatus")
	void testRoomStatus() {

		assertEquals("available", inputValidation.roomStatus(1));
	}

	@Test
	@DisplayName("Date")
	void testDate() {

		assertEquals(true, inputValidation.date("2020-05-04"));
	}

	@Test

	@DisplayName("RoomAvailabilities")
	void testRoomAvailabilities() {

		assertEquals("FREE WIFI", inputValidation.availabilities(1));
	}

}
