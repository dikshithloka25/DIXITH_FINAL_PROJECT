package com.capgemini.hotelbookingmanagementsystem.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.exception.RoomNoNotFoundException;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.repository.CustomerRepository;
import com.capgemini.hotelbookingmanagementsystem.repository.HotelRepository;
import com.capgemini.hotelbookingmanagementsystem.services.AdminService;
import com.capgemini.hotelbookingmanagementsystem.services.CustomerService;

public class EmployeeManagementController {
	static Logger logger = Logger.getLogger(EmployeeManagementController.class);
	Scanner scanner = new Scanner(System.in);
	AdminService adminService = HotelFactory.getAdminService();
	CustomerService customerService = HotelFactory.getCustomerServiceImpl();

	/**
	 * This method is for Employee Login
	 */
	public void employeeLogin() {
		logger.info("Enter HotelID : ");
		String hotelId1 = scanner.next();
		while (!HotelFactory.getAdminService().validateHotelId(hotelId1)) {
			logger.info("please Enter Valid Hotel Id (only numbers & 4 digits)");
			hotelId1 = scanner.next();
		}
		int hotelId = Integer.parseInt(hotelId1);
		logger.info("Enter Password :");
		String password = scanner.next();
		while (!HotelFactory.getCustomerServiceImpl().validatePassword(password)) {
			logger.info("password incorrect");
			password = scanner.next();

		}

		if (HotelFactory.getEmployeeManagementService().getEmployeeLoginService(hotelId, password)) {
			logger.info("Login Successfull... \n");
			Hotel hotel = customerService.getHotelService(hotelId);
			logger.info("Welcome to " + hotel.getHotelName() + "\n");
			m: do {
				logger.info("1.Room Booking");
				logger.info("2.Booking Status");
				logger.info("3.Customer List");
				logger.info("4.Logout");

				String option2 = scanner.next();

				while (!adminService.validateOption3(option2)) {
					logger.info("please Select Valid Option");
					option2 = scanner.next();
				}

				int option = Integer.parseInt(option2);

				switch (option) {
				case 1:
					try {
						if (customerService.getBookingHotelService(hotelId)) {
							logger.info(HotelRepository.hotelRoomList.get(hotel));
							logger.info("Enter Room No (From The Above Given List)");
							String roomNo = scanner.next();
							while (!adminService.validateRoomNo(roomNo)) {
								logger.info(
										"Please Enter Valid Room Number (5 digits && combination of characters,number)");
								roomNo = scanner.next();
							}
							if (customerService.getRoomService(hotel, roomNo)) {
								logger.info("From Date (YYYY-MM-DD):");
								String fromDate = scanner.next();
								while (!customerService.validateDate(fromDate)) {
									logger.info("Please Enter Valid Date In The Format YYYY-MM-DD ");
									fromDate = scanner.next();
								}
								LocalDate from = LocalDate.parse(fromDate);

								while (LocalDate.now().isAfter(from) || LocalDate.now().plusDays(10l).isBefore(from)) {
									logger.info("From Date Must be in Between 10 days from Today\n");
									logger.info("Please Enter Date Again (YYYY-MM-DD):");
									fromDate = scanner.next();
									while (!customerService.validateDate(fromDate)) {
										logger.info("Please Enter Valid Date In The Format YYYY-MM-DD ");
										fromDate = scanner.next();
									}
									from = LocalDate.parse(fromDate);
								}

								logger.info("To Date (YYYY-MM-DD):");
								String toDate = scanner.next();
								while (!customerService.validateDate(toDate)) {
									logger.info("Please Enter Valid Date In The Format YYYY-MM-DD ");
									toDate = scanner.next();
								}
								LocalDate to = LocalDate.parse(toDate);
								if (from.isAfter(to) || from.plusDays(10l).isBefore(to)) {
									logger.info("You can Book the Room For Maximum 10 Days from FromDate  \n");
									logger.info("Please Enter New Date (YYYY-MM-DD)");
									toDate = scanner.next();
									while (!customerService.validateDate(toDate)) {
										logger.info("Please Enter Valid Date In The Format YYYY-MM-DD ");
										toDate = scanner.next();
									}
									to = LocalDate.parse(toDate);
								}

								logger.info("Enter Your Name");
								scanner.nextLine();
								String guest = scanner.nextLine();
								while (!customerService.validateName(guest)) {
									logger.info("Please enter valid Name (only Alphabets)");
									guest = scanner.nextLine();
								}

								logger.info("Room is Reserved \n");

								customerService.getBookingRoomService(hotel, roomNo, from, to, guest);
							} else {
								throw new RoomNoNotFoundException();
							}

						}
					} catch (RoomNoNotFoundException e) {
						logger.info("You must Enter RoomNo which is in the given List and it must be 'available' \n");
					} catch (DateTimeParseException c) {
						logger.info("Invalid Date  \n");
					}
					break;
				case 2:
					logger.info(HotelRepository.hotelBookingList.get(hotelId));

					break;
				case 3:

					logger.info(CustomerRepository.list);

					break;
				case 4:
					logger.info("Logout successfull \n");
					break m;
				default:
					logger.info("Please select valid option \n");
					break;
				}

			} while (true);

		} else {
			logger.info("Login Failed...");
		}
	}

}
