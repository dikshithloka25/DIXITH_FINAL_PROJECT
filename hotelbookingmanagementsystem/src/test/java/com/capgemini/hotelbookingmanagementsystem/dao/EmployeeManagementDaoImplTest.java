package com.capgemini.hotelbookingmanagementsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;

class EmployeeManagementDaoImplTest {
	EmployeeManagementDao employeeDao = HotelFactory.getEmployeeManagementDaoImpl();

	@Test
	void testLogin() {
		assertEquals(true, employeeDao.login(1001, "employee@123"));
	}

}
