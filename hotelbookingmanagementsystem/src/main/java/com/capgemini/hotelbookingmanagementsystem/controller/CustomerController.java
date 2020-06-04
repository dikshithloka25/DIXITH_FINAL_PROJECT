package com.capgemini.hotelbookingmanagementsystem.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingmanagementsystem.bean.Address;
import com.capgemini.hotelbookingmanagementsystem.bean.Customer;
import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.dao.CustomerDaoImpl;
import com.capgemini.hotelbookingmanagementsystem.exception.EmailAlreadyExistsException;
import com.capgemini.hotelbookingmanagementsystem.exception.HotelIdNotFoundException;
import com.capgemini.hotelbookingmanagementsystem.exception.NoRoomsBookedException;
import com.capgemini.hotelbookingmanagementsystem.exception.RoomNoNotFoundException;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.repository.CustomerRepository;
import com.capgemini.hotelbookingmanagementsystem.repository.HotelRepository;
import com.capgemini.hotelbookingmanagementsystem.services.AdminService;
import com.capgemini.hotelbookingmanagementsystem.services.CustomerService;

public class CustomerController {
	static Logger logger = Logger.getLogger(CustomerController.class);
	Scanner scanner = new Scanner(System.in);
	CustomerService customerService = HotelFactory.getCustomerServiceImpl();

	/**
	 * This method is for Customer Controller
	 */
	public void customerController() {
		a: do {
			logger.info("Select any Option (1-3) \n");
			logger.info("1.Customer Login ");
			logger.info("2.Customer Registration");
			logger.info("3.back");

			String option1 = scanner.next();
			while (!customerService.validateOption2(option1)) {
				logger.info("please enter valid option (1-3)");
				option1 = scanner.next();
			}

			int option = Integer.parseInt(option1);

			switch (option) {

			case 1:
				logger.info("**************** Welcome to Customer Login *******************\n");
				logger.info("Enter Email ID (must include '@' character)");
				String emailId = scanner.next();

				while (!customerService.validateEmail(emailId)) {
					logger.info("please enter valid email id (must include '@' character)");
					emailId = scanner.next();
				}

				logger.info("Enter Password (min 8 characters)");
				String password = scanner.next();

				while (!customerService.validatePassword(password)) {
					logger.info("Please valid a valid Password (min 8 characters)");
					password = scanner.next();
				}

				if (customerService.getCustomerLoginService(emailId, password)) {
					logger.info("Login Successfull.....\n");
					String customerName = customerService.getCustomerNameService(emailId, password);
					logger.info("****************** Welcome " + customerName + " **********************\n");
					controller();
				} else {
					logger.info("Login Failed");
					logger.info("Please enter Valid Login Credentials...\n");
				}

				break;

			case 2:

				int count = 0;

				logger.info("***************************** Registration Portal ********************************* \n");
				logger.info("Enter Full Name");
				scanner.nextLine();
				String fullName = scanner.nextLine();
				while (!customerService.validateName(fullName)) {
					logger.info("please enter valid name (only Alphabets)");
					fullName = scanner.nextLine();
				}

				logger.info("Enter your Mobile Number (starts with 6,7,8,9 and 10 digits)");
				String phnNo1 = scanner.nextLine();
				while (!customerService.validatePhnno(phnNo1)) {
					logger.info("Please enter valid Mobile Number (starts with 6,7,8,9 and 10 digits)");
					phnNo1 = scanner.nextLine();
				}
				long phnNo = Long.parseLong(phnNo1);

				logger.info("Enter Email ID (must Include '@' character)");
				String email = scanner.nextLine();
				Iterator<Customer> itr = CustomerRepository.list.iterator();
				while (itr.hasNext()) {
					Customer customer1 = itr.next();
					if (email.equals(customer1.getCustomerEmail())) {
						count++;
					}
				}
				try {
					if (count != 0) {
						throw new EmailAlreadyExistsException();

					} else {

						while (!customerService.validateEmail(email)) {
							logger.info("please enter valid Email id (must include '@' character)");
							email = scanner.nextLine();
						}
					}
				} catch (EmailAlreadyExistsException e) {
					logger.error(e.getMessage());
					logger.info("Please Enter New Email ID (must include '@' character)");
					email = scanner.nextLine();
					while (!customerService.validateEmail(email)) {
						logger.info("please enter valid email id (must include '@' character)");
						email = scanner.nextLine();
					}

				}

				logger.info("Set a Password (min 8 characters) ");
				String password1 = scanner.nextLine();
				while (!customerService.validatePassword(password1)) {
					logger.info("Please Set a valid Password (min 8 characters)");
					password1 = scanner.nextLine();
				}

				logger.info("Enter Adhaar Number (must contain 12 digits) ");
				String adhaar = scanner.nextLine();
				while (!customerService.validateAdhaarNo(adhaar)) {
					logger.info("Please enter valid Adhaar Number (must contain 12 digits)");
					adhaar = scanner.nextLine();
				}
				long adhaarNo = Long.parseLong(adhaar);

				logger.info("Enter your Age (>21 && <100)");
				String age1 = scanner.nextLine();
				while (!customerService.validateAge(age1)) {
					logger.info("Please enter valid Age (>21 && <100)");
					age1 = scanner.nextLine();
				}
				Integer age = Integer.parseInt(age1);
				logger.info("Enter Address \n");
				logger.info("H-No :");
				String hNo = scanner.nextLine();
				while (!customerService.validateHno(hNo)) {
					logger.info("Please enter valid House Number ");
					hNo = scanner.nextLine();
				}
				logger.info("Street :");
				String street = scanner.nextLine();

				while (!customerService.validateAddress(street)) {
					logger.info("Please enter valid Street Name ");
					street = scanner.nextLine();
				}
				logger.info("City :");
				String city = scanner.nextLine();
				while (!customerService.validateAddress(street)) {
					logger.info("Please enter valid City Name ");
					city = scanner.nextLine();
				}
				logger.info("State :");
				String state = scanner.nextLine();
				while (!customerService.validateAddress(street)) {
					logger.info("Please enter valid State Name ");
					state = scanner.nextLine();
				}

				Address address = new Address(hNo, street, city, state);
				Customer customer = new Customer(fullName, phnNo, email, adhaarNo, age, password1, address);

				if (customerService.getRegistrationservice(customer)) {
					logger.info("Registration successFull....\n");
				} else {
					logger.info("Registration failed");
				}

				break;
			case 3:
				break a;
			default:
				break;
			}

		} while (true);
	}

	/**
	 * This method is for Customer Operations
	 */
	public void controller() {

		m: do {
			logger.info("Select any Option \n");
			logger.info("1.Hotel Booking");
			logger.info("2.Booking Status");
			logger.info("3.Logout");

			String option2 = scanner.next();
			while (!customerService.validateOption2(option2)) {
				logger.info("please Select Valid Option (1-3)");
				option2 = scanner.next();

			}
			int option1 = Integer.parseInt(option2);

			switch (option1) {
			case 1:
				customerBooking();
				break;
			case 2:
				logger.info("List of Bookings \n");
				CustomerService bookingStatusService = HotelFactory.getCustomerServiceImpl();
				try {
					if (bookingStatusService.bookingListService()) {

						logger.info(bookingStatusService.bookingStatusService());
					} else {
						throw new NoRoomsBookedException();
					}
				} catch (NoRoomsBookedException e) {
					logger.info(e.getMessage());
				}
				break;
			case 3:

				logger.info("Logout successfull \n");
				CustomerDaoImpl.customerBookingList.clear();

				break m;
			default:
				logger.info("Please Select Valid Option \n");
				break;
			}
		} while (true);

	}

	/**
	 * This method is for Customer Bookings
	 */
	public void customerBooking() {
		AdminService adminService = HotelFactory.getAdminService();
		logger.info("------------------- HOTEL BOOKING PORTAL -------------------\n");
		logger.info("List of Hotels..\n");
		logger.info(HotelRepository.hotelRoomList.keySet());
		logger.info("Enter Hotel ID (From The Above Given List)");
		String hotelId1 = scanner.next();
		while (!adminService.validateHotelId(hotelId1)) {
			logger.info("Please Enter Valid Hotel ID (only numbers & 4 digits)");
			hotelId1 = scanner.next();
		}
		Integer hotelId = Integer.parseInt(hotelId1);
		try {
			if (customerService.getBookingHotelService(hotelId)) {

				Hotel hotel = customerService.getHotelService(hotelId);
				logger.info("Welcome to " + hotel.getHotelName() + "\n");
				logger.info(HotelRepository.hotelRoomList.get(hotel));
				logger.info("-------------------- ROOM BOOKING PORTAL ---------------------");

				logger.info("Enter Room No (From The Above Given List)");
				String roomNo = scanner.next();
				while (!adminService.validateRoomNo(roomNo)) {
					logger.info("Please Enter Valid Room Number (5 digits && combination of characters,number)");
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

			} else {

				throw new HotelIdNotFoundException();
			}
		} catch (HotelIdNotFoundException e1) {
			logger.info(e1.getMessage());
		} catch (RoomNoNotFoundException e) {
			logger.info("You must Enter RoomNo which is in the given List and it must be 'available' \n");
		} catch (DateTimeParseException c) {
			logger.info("Invalid Date  \n");
		}

	}

}
