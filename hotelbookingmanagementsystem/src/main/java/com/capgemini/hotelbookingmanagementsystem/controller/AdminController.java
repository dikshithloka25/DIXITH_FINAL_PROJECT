package com.capgemini.hotelbookingmanagementsystem.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;
import com.capgemini.hotelbookingmanagementsystem.exception.DateNotFoundException;
import com.capgemini.hotelbookingmanagementsystem.exception.HotelIdExistsException;
import com.capgemini.hotelbookingmanagementsystem.exception.HotelIdNotFoundException;
import com.capgemini.hotelbookingmanagementsystem.exception.NoRoomsBookedException;
import com.capgemini.hotelbookingmanagementsystem.exception.RoomNoExistsException;
import com.capgemini.hotelbookingmanagementsystem.exception.RoomNoNotFoundException;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.repository.HotelRepository;
import com.capgemini.hotelbookingmanagementsystem.services.AdminService;

public class AdminController {

	static Logger logger = Logger.getLogger(AdminController.class);
	Scanner scanner = new Scanner(System.in);

	AdminService adminService = HotelFactory.getAdminService();

	/**
	 * This method is for Admin login
	 */
	public void adminLogin() {
		Properties properties = new Properties();
		try { 
			properties.load(new FileInputStream("db.properties"));
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
		String email = properties.getProperty("adminEmail");

		String password = properties.getProperty("adminPassword");

		if (adminService.getAdminLoginService(email, password)) {
			logger.info("Login Successfull... \n");
			logger.info("**************Welcome ADMIN**************\n");
			adminController();	
		} else {
			logger.info("Login Failed...");
		}
	}

	/**
	 * This method is for Admin Controller
	 */

	public void adminController() {

		a: do {
			logger.info("Select Any Option \n");
			logger.info("1.Hotel Operations");
			logger.info("2.Room Operations");
			logger.info("3.Reports");
			logger.info("4.Logout");

			String option2 = scanner.next();
			while (!adminService.validateOption3(option2)) {
				logger.info("Please Select Valid Option(1-4)");
				option2 = scanner.next();
			}
			int option = Integer.parseInt(option2);

			switch (option) {

			case 1:
				hotelController();
				break;
			case 2:
				roomController();
				break;
			case 3:
				reportsController();
				break;
			case 4:
				logger.info("Logout successfull \n");
				break a;
			default:
				logger.info("Please Enter Valid Option \n");
				break;

			}

		} while (true);
	}

	/**
	 * This method is for Hotel crud Operations
	 */

	public void hotelController() {

		b: do {
			logger.info("-------------------- Hotel Operations --------------------\n ");
			logger.info("Select Any Option \n");
			logger.info("1.Add hotel");
			logger.info("2.Delete Hotel");
			logger.info("3.Update Hotel");
			logger.info("4.Back");

			String option2 = scanner.next();
			while (!adminService.validateOption3(option2)) {
				logger.info("please Select Valid Option(1-4)");
				option2 = scanner.next();
			}
			int option = Integer.parseInt(option2);

			switch (option) {

			case 1:

				int count = 0;
				logger.info(HotelRepository.hotelRoomList.keySet());
				logger.info("Enter Hotel ID (only numbers & 4 digits)");
				scanner.nextLine();
				String hotelId1 = scanner.nextLine();
				while (!adminService.validateHotelId(hotelId1)) {
					logger.info("Please Enter Valid Hotel ID (only numbers & 4 digits)");
					hotelId1 = scanner.nextLine();
				}
				Integer hotelId = Integer.parseInt(hotelId1);

				Iterator<Hotel> itr = HotelRepository.hotelRoomList.keySet().iterator();
				while (itr.hasNext()) {

					Hotel hotel2 = itr.next();
					if (hotelId == hotel2.getHotelId()) {

						count = 3;
					}
				}
				try {
					if (count == 3) {
						throw new HotelIdExistsException();
					}
				} catch (HotelIdExistsException e) {
					logger.error(e.getMessage());

					logger.info("Please enter Different Hotel Id (which is not present in the above List)");
					hotelId1 = scanner.nextLine();
					while (!adminService.validateHotelId(hotelId1)) {
						logger.info("Please Enter Valid Hotel ID (only numbers & 4 digits)");
						hotelId1 = scanner.nextLine();
					}
					hotelId = Integer.parseInt(hotelId1);

				}
				logger.info("Enter Hotel Name ");
				String hotelName = scanner.nextLine();

				while (!adminService.validateHotelName(hotelName)) {
					logger.info("Please Enter Valid Hotel Name ");
					hotelName = scanner.nextLine();
				}

				int hotelNoofRooms = 0;

				logger.info("Enter Hotel Description (eg:5* hotel)");
				String hotelDescription = scanner.nextLine();
				while (!adminService.validateHotelDescription(hotelDescription)) {
					logger.info("Please Enter Valid Hotel Description ");
					hotelDescription = scanner.nextLine();
				}

				logger.info("Enter Hotel Address:(please enter street,City,State)");
				String hotelAddress = scanner.nextLine();
				while (!adminService.validateHotelAddress(hotelAddress)) {
					logger.info("Please Enter Valid Hotel Address ");
					hotelAddress = scanner.nextLine();
				}
				logger.info("Set a password");
				String password = scanner.nextLine();
				while (!HotelFactory.getCustomerServiceImpl().validatePassword(password)) {
					logger.info("Please Enter Valid password ");
					hotelAddress = scanner.nextLine();
					
				}
				Hotel hotel = new Hotel(hotelId, hotelName, hotelNoofRooms, hotelDescription, hotelAddress,password);

				if (adminService.getAddHotelService(hotel)) {
					logger.info(hotel.getHotelName() + " Added Successfully.....\n");

				} else {
					logger.error("Hotel not Added \n");
				}

				break;
			case 2:
				int count2 = 0;
				logger.info(HotelRepository.hotelRoomList.keySet());
				logger.info("Enter Hotel ID (From The Above Given List) ");
				String hotelId2 = scanner.next();
				while (!adminService.validateHotelId(hotelId2)) {
					logger.info("Please Enter Valid Hotel ID (only numbers & 4 digits)");
					hotelId2 = scanner.next();
				}
				Integer hotelId9 = Integer.parseInt(hotelId2);

				if (adminService.getHotelIdService(hotelId9)) {
					count2++;
					if (adminService.getDeleteHotelService(hotelId9)) {

						logger.info("Hotel Deleted Successfully...... \n");

					}
				}
				try {
					if (count2 == 0) {
						throw new HotelIdNotFoundException();

					}
				} catch (HotelIdNotFoundException e) {
					logger.error(e.getMessage());
				}
				break;
			case 3:

				logger.info(HotelRepository.hotelRoomList.keySet());
				logger.info("Enter Hotel ID (From The Above Given List)");
				String hotelId3 = scanner.next();
				while (!adminService.validateHotelId(hotelId3)) {
					logger.info("Please Enter Valid Hotel ID (only numbers & 4 digits) ");
					hotelId3 = scanner.next();
				}
				Integer hotelId4 = Integer.parseInt(hotelId3);
				try {
					if (adminService.getHotelIdService(hotelId4)) {

						logger.info("Update Hotel ID (only numbers & 4 digits)");
						scanner.nextLine();
						String hotelId5 = scanner.nextLine();
						while (!adminService.validateHotelId(hotelId3)) {
							logger.info("Please Enter Valid Hotel ID (only numbers & 4 digits)");
							hotelId5 = scanner.nextLine();
						}
						Integer hotelId6 = Integer.parseInt(hotelId5);

						logger.info("Update Hotel Name ");
						String hotelName1 = scanner.nextLine();

						while (!adminService.validateHotelName(hotelName1)) {

							logger.info("Please Enter Valid Hotel Name ");
							hotelName1 = scanner.nextLine();
						}

						logger.info("Update Hotel Description (eg:5* hotel)");
						String hotelDescription1 = scanner.nextLine();
						while (!adminService.validateHotelDescription(hotelDescription1)) {
							logger.info("Please Enter Valid Hotel Description ");
							hotelDescription1 = scanner.nextLine();
						}

						logger.info("Update Hotel Address (Enter street,City & State)");
						String hotelAddress1 = scanner.nextLine();
						while (!adminService.validateHotelAddress(hotelAddress1)) {
							logger.info("Please Enter Valid Hotel Address ");
							hotelAddress1 = scanner.nextLine();
						}

						Hotel hotel1 = HotelFactory.getCustomerDaoImpl().getHotel(hotelId4);
						hotel1.setHotelId(hotelId6);
						hotel1.setHotelName(hotelName1);
						hotel1.setNoOfRooms(0);
						hotel1.setDescription(hotelDescription1);
						hotel1.setHotelAddress(hotelAddress1);

						if (adminService.getUpdateHotelService(hotelId6, hotel1)) {
							logger.info(hotel1.getHotelName() + " Updated Successfull...\n");
						} else {
							logger.info("update failed");
						}
					} else {

						throw new HotelIdNotFoundException();
					}
				} catch (HotelIdNotFoundException c) {
					logger.error(c.getMessage());
				}

				break;
			case 4:
				break b;
			default:
				logger.info("please enter valid option \n");
				break;

			}
		} while (true);

	}

	/**
	 * This method is for Room crud Operations
	 */

	public void roomController() {

		c: do {
			logger.info("-------------------- Room Operations -----------------------\n ");
			logger.info("Select Any Option \n");
			logger.info("1.Add Room");
			logger.info("2.Delete Room");
			logger.info("3.Update Room");
			logger.info("4.Back");

			String option2 = scanner.next();

			while (!adminService.validateOption3(option2)) {
				logger.info("please Select Valid Option (1-4)");
				option2 = scanner.next();
			}

			int option = Integer.parseInt(option2);

			switch (option) {

			case 1:
				int count = 0;
				logger.info(HotelRepository.hotelRoomList.keySet());
				logger.info("Enter Hotel ID (From The Above Given List)");
				String hotelId2 = scanner.next();
				while (!adminService.validateHotelId(hotelId2)) {
					logger.info("Please Enter Valid Hotel ID (only numbers & 4 digits)");
					hotelId2 = scanner.next();
				}
				Integer hotelId3 = Integer.parseInt(hotelId2);
				try {
					if (adminService.getHotelIdService(hotelId3)) {
						Hotel hotel = HotelFactory.getCustomerDaoImpl().getHotel(hotelId3);

						logger.info(HotelRepository.hotelRoomList.get(hotel));
						logger.info("Enter Room Number(that is not in the list above)");
						scanner.nextLine();
						String roomNo = scanner.nextLine();
						Iterator<Room> room1 = HotelRepository.hotelRoomList.get(hotel).iterator();
						while (room1.hasNext()) {
							Room room2 = room1.next();
							if (roomNo.equals(room2.getRoomNo())) {
								count = 8;
							}
						}
						try {
							if (count == 8) {
								throw new RoomNoExistsException();
							} else {

								while (!adminService.validateRoomNo(roomNo)) {
									logger.info(
											"Please Enter Valid Room Number (5 digits && combination of characters,number)");
									roomNo = scanner.nextLine();
								}
							}
						} catch (RoomNoExistsException e) {
							logger.error(e.getMessage());
							logger.info("Please Enter different Room Number (that is not in the list above)\n");
							roomNo = scanner.nextLine();
						}

						logger.info("Enter Room Price");
						String roomPrice1 = scanner.nextLine();
						while (!adminService.validateRoomPrice(roomPrice1)) {
							logger.info("Please Enter Valid Room price");
							roomPrice1 = scanner.nextLine();
						}
						Double roomPrice = Double.parseDouble(roomPrice1);

						logger.info("select any option for RoomStatus (1-3)");
						logger.info("1.available \n2.reserved \n3.Under Maintenance");
						String option1 = scanner.nextLine();

						while (!HotelFactory.getCustomerServiceImpl().validateOption2(option1)) {
							logger.info("please Select Valid Option (1-3)");
							option1 = scanner.nextLine();

						}

						int option3 = Integer.parseInt(option1);
						String roomStatus = adminService.validateRoomStatus(option3);

						logger.info("Enter Room Availabilities:(select any 3 options)");
						logger.info("1.FREE WIFI \n2.TV \n3.COOLER \n4.A/C \n");

						String roomAvailabilities[] = new String[3];
						for (int i = 0; i < roomAvailabilities.length; i++) {
							String option7 = scanner.nextLine();

							while (!adminService.validateOption3(option7)) {
								logger.info("please Select Valid Option (1-4)");
								option7 = scanner.nextLine();
							}
							int availables = Integer.parseInt(option7);

							roomAvailabilities[i] = adminService.validateAvailabilities(availables);
						}

						logger.info("select any option for Room Type (1-3)");
						logger.info("1.Single bedroom \n2.Double bedroom \n3.Triple bedroom ");
						String option8 = scanner.nextLine();

						while (!HotelFactory.getCustomerServiceImpl().validateOption2(option8)) {
							logger.info("please Select Valid Option (1-3)");
							option8 = scanner.nextLine();

						}

						int option9 = Integer.parseInt(option8);

						String roomType = adminService.validateRoomType(option9);

						LocalDate fromDate = null;

						LocalDate toDate = null;

						String name = null;

						Room room = new Room(roomNo, roomType, name, roomPrice, roomStatus, roomAvailabilities,
								fromDate, toDate);
						if (adminService.getAddRoomService(hotelId3, room)) {
							logger.info("Room Added Successfully.....");
						}
					} else {
						throw new HotelIdNotFoundException();
					}
				} catch (HotelIdNotFoundException e) {
					logger.error(e.getMessage());
				}
				break;
			case 2:

				logger.info(HotelRepository.hotelRoomList.keySet());
				logger.info("Enter Hotel ID (From The Above Given List)");
				String hotelId1 = scanner.next();
				while (!adminService.validateHotelId(hotelId1)) {
					logger.info("Please Enter Valid Hotel ID (only numbers & 4 digits) ");
					hotelId1 = scanner.next();
				}
				Integer hotelId = Integer.parseInt(hotelId1);
				try {
					if (adminService.getHotelIdService(hotelId)) {

						Hotel hotel = HotelFactory.getCustomerDaoImpl().getHotel(hotelId);
						logger.info("Welcome to " + hotel.getHotelName());
						logger.info(HotelRepository.hotelRoomList.get(hotel));
						logger.info("Enter Roomno (From The Above Given List)");
						String roomNo = scanner.next();
						while (!adminService.validateRoomNo(roomNo)) {
							logger.info("Please Enter Valid Room Number");
							roomNo = scanner.next();
						}
						if (adminService.getAdminRoomService(hotel, roomNo)) {

							if (adminService.getDeleteRoomService(hotelId, roomNo)) {

								logger.info("Room Deleted Successfully....\n");
							}
						} else {

							throw new RoomNoNotFoundException();
						}
					} else {

						throw new HotelIdNotFoundException();
					}

				} catch (HotelIdNotFoundException e1) {
					logger.info(e1.getMessage());

				} catch (RoomNoNotFoundException e) {
					logger.info(e.getMessage());

				}

				break;
			case 3:

				logger.info(HotelRepository.hotelRoomList.keySet());
				logger.info("Enter Hotel ID (From The Above Given List)");
				String hotelId4 = scanner.next();
				while (!adminService.validateHotelId(hotelId4)) {
					logger.info("Please Enter Valid Hotel ID (only numbers & 4 digits) ");
					hotelId4 = scanner.next();
				}
				Integer hotelId5 = Integer.parseInt(hotelId4);
				try {
					if (adminService.getHotelIdService(hotelId5)) {

						Hotel hotel = HotelFactory.getCustomerDaoImpl().getHotel(hotelId5);
						logger.info("Welcome to " + hotel.getHotelName());
						logger.info(HotelRepository.hotelRoomList.get(hotel));
						logger.info("Enter Roomno (From The Above Given List)");
						String roomNo = scanner.next();
						while (!adminService.validateRoomNo(roomNo)) {
							logger.info("Please Enter Room Number From The Above Given List");
							roomNo = scanner.next();
						}
						if (adminService.getAdminRoomService(hotel, roomNo)) {

							logger.info("Update Room Number (5 digits && combination of number,characters)");
							scanner.nextLine();
							String roomNo1 = scanner.nextLine();
							while (!adminService.validateRoomNo(roomNo1)) {
								logger.info("Please Enter Valid Room Number");
								roomNo1 = scanner.nextLine();
							}

							logger.info("Update Room Price");
							String roomPrice1 = scanner.nextLine();
							while (!adminService.validateRoomPrice(roomPrice1)) {
								logger.info("Please Enter Valid Room price");
								roomPrice1 = scanner.nextLine();
							}
							Double roomPrice = Double.parseDouble(roomPrice1);

							logger.info("Update Room Availabilities:(select any 3 options)");
							logger.info("1.FREE WIFI \n2.TV \n3.COOLER \n4.A/C \n");

							String roomAvailabilities[] = new String[3];
							for (int i = 0; i < roomAvailabilities.length; i++) {
								String option10 = scanner.nextLine();
								while (!adminService.validateOption3(option10)) {
									logger.info("please Select Valid Option (1-3)");
									option10 = scanner.nextLine();
								}
								int availables = Integer.parseInt(option10);

								roomAvailabilities[i] = adminService.validateAvailabilities(availables);
							}

							logger.info("Select any Option to Update Room Status");
							logger.info("1.available \n2.reserved \n3.Under Maintenance");
							String option1 = scanner.nextLine();
							while (!HotelFactory.getCustomerServiceImpl().validateOption2(option1)) {
								logger.info("please Select Valid Option(1-3)");
								option1 = scanner.nextLine();

							}
							int option3 = Integer.parseInt(option1);
							String roomStatus = adminService.validateRoomStatus(option3);

							logger.info("Select any Option to Update Room Type");
							logger.info("1.Single bedroom \n 2.Double bedroom \n 3.Triple bedroom");
							String option6 = scanner.nextLine();
							while (!HotelFactory.getCustomerServiceImpl().validateOption2(option6)) {
								logger.info("please Select Valid Option (1-3)");
								option6 = scanner.nextLine();

							}
							int option7 = Integer.parseInt(option6);
							String roomType = adminService.validateRoomType(option7);
							LocalDate fromDate = null;

							LocalDate toDate = null;

							String name = null;
							Room room = adminService.getRoomService(hotelId5, roomNo);

							room.setRoomNo(roomNo1);
							room.setRoomStatus(roomStatus);
							room.setRoomPrice(roomPrice);
							room.setRoomType(roomType);
							room.setAvailabilities(roomAvailabilities);
							room.setFrom(fromDate);
							room.setTo(toDate);
							room.setGuestName(name);
							if (adminService.getUpdateRoomService(hotelId5, roomNo1, room)) {

								logger.info("Room Updated successfully....");
							}

						} else {

							throw new RoomNoNotFoundException();
						}

					} else {

						throw new HotelIdNotFoundException();
					}
				} catch (HotelIdNotFoundException e1) {
					logger.info(e1.getMessage());

				} catch (RoomNoNotFoundException e) {
					logger.info("Room Not found,You Must Select From the Given List \n");
				}

				break;
			case 4:
				break c;
			default:
				logger.info("please enter valid option \n");
				break;

			}
		} while (true);
	}

	/**
	 * This method is for Admin Reports
	 */

	public void reportsController() {
		d: do {
			logger.info("-------------------- ADMIN REPORTS --------------------\n ");
			logger.info("Select Any Option \n");
			logger.info("1.List of Hotels");
			logger.info("2.Bookings of Hotel");
			logger.info("3.Guest of Hotel");
			logger.info("4.Bookings of Date");
			logger.info("5.Back");

			String option1 = scanner.next();

			while (!adminService.validateOption1(option1)) {
				logger.info("Please Select valid Option (1-5)");
				option1 = scanner.next();

			}

			int option = Integer.parseInt(option1);

			switch (option) {

			case 1:
				logger.info("List Of Hotels \n");
				logger.info(HotelRepository.hotelRoomList.keySet());
				break;
			case 2:
				logger.info(HotelRepository.hotelRoomList.keySet());
				logger.info("Enter Hotel ID (From The Above Given List)");
				String hotelId2 = scanner.next();
				while (!adminService.validateHotelId(hotelId2)) {
					logger.info("Please Enter Valid Hotel ID ");
					hotelId2 = scanner.next();
				}
				Integer hotelId1 = Integer.parseInt(hotelId2);
				try {
					if (adminService.getHotelIdService(hotelId1)) {
						logger.info(
								"Welcome to " + HotelFactory.getCustomerDaoImpl().getHotel(hotelId1).getHotelName());
						if (adminService.getSpecificHotelService(hotelId1).isEmpty()) {
							throw new NoRoomsBookedException();
						} else {
							logger.info(adminService.getSpecificHotelService(hotelId1));
						}
					} else {
						throw new HotelIdNotFoundException();

					}
				} catch (HotelIdNotFoundException e1) {
					logger.info(e1.getMessage());

				} catch (NoRoomsBookedException e) {
					logger.info(e.getMessage());

				}
				break;
			case 3:
				logger.info(HotelRepository.hotelRoomList.keySet());
				logger.info("Enter Hotel ID (From The Above Given List)");
				String hotelId3 = scanner.next();
				while (!adminService.validateHotelId(hotelId3)) {
					logger.info("Please Enter Valid Hotel ID ");
					hotelId3 = scanner.next();
				}
				Integer hotelId = Integer.parseInt(hotelId3);
				try {
					if (adminService.getHotelIdService(hotelId)) {
						logger.info("Welcome to " + HotelFactory.getCustomerDaoImpl().getHotel(hotelId).getHotelName());
						if (adminService.getGuestNameService(hotelId).isEmpty()) {
							throw new NoRoomsBookedException();
						} else {
							logger.info(adminService.getGuestNameService(hotelId));
						}
					} else {
						throw new HotelIdNotFoundException();
					}
				} catch (HotelIdNotFoundException e1) {
					logger.info(e1.getMessage());

				} catch (NoRoomsBookedException e) {
					logger.info(e.getMessage());

				}
				break;
			case 4:
				logger.info("Enter Specific Date (YYYY-MM-DD) :");
				String date = scanner.next();
				while (!HotelFactory.getCustomerServiceImpl().validateDate(date)) {
					logger.info("Please Enter Valid Date In The Format YYYY-MM-DD ");
					date = scanner.next();
				}
				try {
					LocalDate ld = LocalDate.parse(date);
					if (adminService.getByDateService(ld).isEmpty()) {
						throw new DateNotFoundException();
					} else {
						logger.info(adminService.getByDateService(ld));
					}
				} catch (DateNotFoundException e) {
					logger.info(e.getMessage());
				} catch (DateTimeParseException e) {
					logger.info("Invalid date \n");
				}
				break;
			case 5:

				break d;
			default:
				break;

			}
		} while (true);

	}

}
