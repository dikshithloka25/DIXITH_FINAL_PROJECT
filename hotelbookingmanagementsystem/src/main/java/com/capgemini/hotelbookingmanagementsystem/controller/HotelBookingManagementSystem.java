package com.capgemini.hotelbookingmanagementsystem.controller;

import java.util.Scanner;
import org.apache.log4j.Logger;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.repository.CustomerRepository;
import com.capgemini.hotelbookingmanagementsystem.repository.HotelRepository;

public class HotelBookingManagementSystem {
	static Scanner scanner = new Scanner(System.in);
	static Logger logger = Logger.getLogger(HotelBookingManagementSystem.class);

	public static void main(String[] args) {

		CustomerRepository.customerRepository();
		HotelRepository.hotelRepository();

		logger.info("*********Welcome To Online Hotel Management Service********* \n");
		do {
			logger.info("Select any Option :\n\n1.Customer \n2.Hotel Management \n3.Admin\n4.Exit\n");
			String option1 = scanner.next();
			while (!HotelFactory.getAdminService().validateOption3(option1)) {
				logger.info("Please Select valid Option (1-4)");
				option1 = scanner.next();
			}
			int option = Integer.parseInt(option1);
			switch (option) {
			case 1:
				HotelFactory.getCustomerController().customerController();
				break;
			case 2:
				HotelFactory.getEmployeeManagementController().employeeLogin();
				break;
			case 3:
				HotelFactory.getAdminController().adminLogin();
				break;
			case 4:
				logger.info("Thank You......");
				scanner.close();
				System.exit(0);
				break;
			default:
				logger.info("please enter valid option \n");
				break;
			}
		} while (true);
	}
}
