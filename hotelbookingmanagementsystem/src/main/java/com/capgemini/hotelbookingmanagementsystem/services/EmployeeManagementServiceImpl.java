package com.capgemini.hotelbookingmanagementsystem.services;

import com.capgemini.hotelbookingmanagementsystem.dao.EmployeeManagementDao;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;

/**
 * This class is to perform Employee Management Service Operations
 * 
 * @author Dixith Reddy
 *
 */
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

	/**
	 * This methods for Employee login
	 * 
	 * @param email    is the first parameter to validateEmployee
	 * @param password is the second parameter to validateEmployee
	 * @return method is true or false
	 */
	public boolean getEmployeeLoginService(int hotelId, String password) {

		EmployeeManagementDao employeeManagementLogin = HotelFactory.getEmployeeManagementDaoImpl();
		if ( (password != null)) {

			return employeeManagementLogin.login(hotelId, password);
		} else {
			return false;
		}

	}

}
