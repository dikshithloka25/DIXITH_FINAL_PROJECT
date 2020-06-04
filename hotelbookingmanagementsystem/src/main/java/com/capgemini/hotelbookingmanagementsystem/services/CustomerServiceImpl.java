package com.capgemini.hotelbookingmanagementsystem.services;

import java.time.LocalDate;
import java.util.List;
import com.capgemini.hotelbookingmanagementsystem.bean.Customer;
import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;
import com.capgemini.hotelbookingmanagementsystem.dao.CustomerDao;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.validations.Validations;

/**
 * This class is about Customer Hotel Booking service.
 * 
 * @author Admin
 *
 */
public class CustomerServiceImpl implements CustomerService {
	CustomerDao customerDao = HotelFactory.getCustomerDaoImpl();
	Validations validations = HotelFactory.getValidations();

	/**
	 * This methods for Customer Registration Service
	 * 
	 * @param Customer class reference as input
	 * @return method is true or false
	 */
	public boolean getRegistrationservice(Customer customer) {

		if (customer != null) {

			return customerDao.customerRegistration(customer);
		}
		return false;
	}

	/**
	 * This methods for Customer login
	 * 
	 * @param email    is the first parameter to validateCustomer
	 * @param password is the second parameter to validateCustomer
	 * @return method is true or false
	 */

	public boolean getCustomerLoginService(String email, String password) {

		if ((email != null) && (password != null)) {
			return customerDao.login(email, password);
		} else {
			return false;
		}
	}

	/**
	 * This methods for getCustomerName
	 * 
	 * @param email    is the first parameter to validateCustomer
	 * @param password is the second parameter to validateCustomer
	 * @return method is String
	 */
	public String getCustomerNameService(String email, String password) {

		if ((email != null) && (password != null)) {
			return customerDao.getCustomerName(email, password);
		} else {
			return null;
		}
	}

	/**
	 * This methods for booking hotel & room in that hotel
	 * 
	 * @param hotelId is parameter to take hotelId as input
	 * @return method is true or false
	 */
	@Override
	public boolean getBookingHotelService(int hotelId) {

		return customerDao.bookingHotel(hotelId);

	}

	/**
	 * This methods for get Hotel Service
	 * 
	 * @param hotelId is the parameter
	 * @return method is Hotel
	 */
	@Override
	public Hotel getHotelService(int hotelId) {

		return customerDao.getHotel(hotelId);
	}

	/**
	 * This methods for Booking Room service
	 * 
	 * @param hotel  is the first parameter as input
	 * @param roomNo is the second parameter as input
	 * @param from   is the third parameter as input
	 * @param to     is the fourth parameter as input
	 * @param name   is the fifth parameter as input
	 * @return method is Room
	 */
	@Override
	public Room getBookingRoomService(Hotel hotel, String roomNo, LocalDate from, LocalDate to, String name) {
		if ((hotel != null) && (roomNo != null) && (from != null) && (to != null) && (name != null)) {

			return customerDao.bookingRoom(hotel, roomNo, from, to, name);
		}
		return null;

	}

	/**
	 * This methods for get Room Service
	 * 
	 * @param hotel  is the first parameter as input
	 * @param roomNo is the second parameter as input
	 * @return method is true or false
	 */
	@Override
	public boolean getRoomService(Hotel hotel, String roomNo) {

		if ((hotel != null) && (roomNo != null)) {
			return customerDao.getRoom(hotel, roomNo);
		}
		return false;
	}

	/**
	 * This methods for booking List status
	 * 
	 * @return method is null
	 */
	@Override
	public boolean bookingListService() {

		return !customerDao.bookingStatus().isEmpty();
	}

	/**
	 * This methods for booking status
	 * 
	 * @return method is null
	 */
	@Override
	public List<Room> bookingStatusService() {

		return customerDao.bookingStatus();
	}

	/**
	 * This method is for validate Email
	 * 
	 * @param email is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public boolean validateEmail(String email) {
		if (email != null) {
			return validations.customerEmail(email);
		} else {
			return false;
		}
	}

	/**
	 * This method is for validate Password
	 * 
	 * @param password is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public boolean validatePassword(String password) {
		if (password != null) {
			return validations.customerPassword(password);
		} else {
			return false;
		}
	}

	/**
	 * This method is for validate Name
	 * 
	 * @param name is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public boolean validateName(String name) {
		if (name != null) {
			return validations.customerName(name);
		} else {
			return false;
		}
	}

	/**
	 * This method is for validate Phnno
	 * 
	 * @param phnno is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public boolean validatePhnno(String phnNo) {
		if (phnNo != null) {
			return validations.customerPhnno(phnNo);
		} else {
			return false;
		}
	}

	/**
	 * This method is for validate Adhaar
	 * 
	 * @param adhaar is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public boolean validateAdhaarNo(String adhaar) {
		if (adhaar != null) {
			return validations.customerAdhaar(adhaar);
		} else {
			return false;
		}
	}

	/**
	 * This method is for validate Age
	 * 
	 * @param age is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public boolean validateAge(String age) {
		if (age != null) {
			return validations.customerAge(age);
		} else {
			return false;
		}
	}

	/**
	 * This method is for validate Hno
	 * 
	 * @param hno is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public boolean validateHno(String hNo) {
		if (hNo != null) {
			return validations.customerHNo(hNo);
		} else {
			return false;
		}
	}

	/**
	 * This method is for validate Address
	 * 
	 * @param address is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public boolean validateAddress(String address) {
		if (address != null) {
			return validations.customerAddress(address);
		} else {
			return false;
		}
	}

	@Override
	public boolean validateOption2(String option) {
		if (option != null) {
			return validations.option2(option);
		} else {
			return false;
		}
	}

	/**
	 * This method is for validate Date
	 * 
	 * @param date is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public boolean validateDate(String date) {
		if (date != null) {
			return validations.date(date);
		} else {
			return false;
		}
	}
}
