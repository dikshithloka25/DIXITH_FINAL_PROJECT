package com.capgemini.hotelbookingmanagementsystem.services;

import java.time.LocalDate;
import java.util.List;
import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;
import com.capgemini.hotelbookingmanagementsystem.dao.AdminOperationsDao;
import com.capgemini.hotelbookingmanagementsystem.exception.HotelIdExistsException;
import com.capgemini.hotelbookingmanagementsystem.exception.HotelIdNotFoundException;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.validations.Validations;

/**
 * This class is to perform Admin Service Operations
 * 
 * @author Dixith Reddy
 *
 */
public class AdminServiceImpl implements AdminService {

	Validations validations = HotelFactory.getValidations();
	AdminOperationsDao adminOperations = HotelFactory.getAdminOperationsDaoImpl();

	/**
	 * This methods for Admin Login Service
	 */
	@Override
	public boolean getAdminLoginService(String email, String password) {
		if ((email != null) && (password != null)) {
			return adminOperations.login(email, password);
		} else {
			return false;
		}
	}

	/**
	 * This methods for Add Hotel Operation Service
	 * 
	 * @exception HotelIdExistsException on input error
	 */
	@Override
	public boolean getAddHotelService(Hotel hotel) {

		if (hotel != null) {
			return adminOperations.addHotel(hotel);
		}
		return false;

	}

	/**
	 * This method is for Delete Hotel
	 * 
	 * @param hotelid is parameter to take input of Hotelid
	 * @return method is true or false
	 */
	@Override
	public boolean getDeleteHotelService(int hotelId) {

		return adminOperations.deleteHotel(hotelId);

	}

	/**
	 * This methods for Update Hotel Operation Service
	 * 
	 * @exception HotelIdNotFoundException on input error
	 */
	@Override
	public boolean getUpdateHotelService(int hotelId, Hotel hotel) {
		if (hotel != null) {

			return adminOperations.updateHotel(hotelId, hotel);
		}
		return false;

	}

	/**
	 * This methods for Add Room Operation Service
	 * 
	 * @exception HotelIdNotFoundException on input error
	 */
	@Override
	public boolean getAddRoomService(int hotelId, Room room) {

		if (room != null) {
			return adminOperations.addRoom(hotelId, room);
		}
		return false;

	}

	/**
	 * This method is for delete room
	 * 
	 * @param hotelid is parameter to take hotelid as input
	 * @return method is true or false
	 */
	@Override
	public boolean getDeleteRoomService(int hotelId, String roomNo) {
		if (roomNo != null) {
			return adminOperations.deleteRoom(hotelId, roomNo);
		} else {
			return false;
		}
	}

	/**
	 * This method is for update room
	 * 
	 * @param hotelid is parameter to take hotelid as input
	 * @return method is true or false
	 */
	@Override
	public boolean getUpdateRoomService(int hotelId, String roomNo, Room room) {

		if ((room != null) && (roomNo != null)) {
			return adminOperations.updateRoom(hotelId, roomNo, room);
		}

		return false;

	}

	/**
	 * This method is for getRoom
	 * 
	 * @param hotelid is parameter to take hotelid as input
	 * @param roomNo  is parameter as input
	 * @return method is Room
	 */
	@Override
	public Room getRoomService(int hotelId, String roomNo) {
		if (roomNo != null) {

			return adminOperations.getHotelRoom(hotelId, roomNo);
		} else {
			return null;
		}
	}

	/**
	 * This methods for get Room
	 * 
	 * @param hotel  is the first parameter as input
	 * @param roomNo is the second parameter as input
	 * @return method is true or false
	 */
	@Override
	public boolean getAdminRoomService(Hotel hotel, String roomNo) {

		if ((hotel != null) && (roomNo != null)) {
			return adminOperations.getAdminRoom(hotel, roomNo);
		}
		return false;
	}

	/**
	 * This method is to Select Hotel using HotelId
	 * 
	 * @param hotelid is parameter as input
	 * @return method is true or false
	 */
	@Override
	public boolean getHotelIdService(int hotelId) {

		return adminOperations.getHotelId(hotelId);

	}

	/**
	 * This method is for specific Hotel Booking List
	 * 
	 * @param hotelID is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public List<Room> getSpecificHotelService(int hotelId) {

		return adminOperations.specificHotelBookingList(hotelId);
	}

	/**
	 * This method is for hotelGuestName
	 * 
	 * @param hotelID is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public List<String> getGuestNameService(int hotelId) {
		return adminOperations.hotelGuestName(hotelId);
	}

	/**
	 * This method is for bookings By Date
	 * 
	 * @param LocalDate is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public List<Room> getByDateService(LocalDate date) {
		if (date != null) {
			return adminOperations.bookingsByDate(date);
		}
		return null; 
	}

	/**
	 * This method is for validate HotelId
	 * 
	 * @param hotelid is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public boolean validateHotelId(String hotelId) {

		return validations.hotelId(hotelId);

	}

	/**
	 * This method is for validate Hotel Name
	 * 
	 * @param hotelName is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public boolean validateHotelName(String hotelName) {
		if (hotelName != null) {
			return validations.hotelName(hotelName);
		} else {
			return false;
		}
	}

	/**
	 * This method is for validate Hotel Description
	 * 
	 * @param description is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public boolean validateHotelDescription(String description) {
		if (description != null) {
			return validations.hotelDescription(description);

		} else {
			return false;
		}

	}

	/**
	 * This method is for validate Hotel Address
	 * 
	 * @param address is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public boolean validateHotelAddress(String address) {
		if (address != null) {
			return validations.hotelAddress(address);
		} else {
			return false;
		}
	}

	/**
	 * This method is for validate RoomNo
	 * 
	 * @param roomNo is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public boolean validateRoomNo(String roomNo) {
		if (roomNo != null) {
			return validations.roomNumber(roomNo);
		} else {
			return false;
		}
	}

	/**
	 * This method is for validateRoomPrice
	 * 
	 * @param roomPrice is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public boolean validateRoomPrice(String roomPrice) {
		if (roomPrice != null) {
			return validations.roomPrice(roomPrice);

		} else {
			return false;
		}
	}

	/**
	 * This method is for validateOption3
	 * 
	 * @param option is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public boolean validateOption3(String option) {
		if (option != null) {
			return validations.option3(option);
		} else {
			return false;
		}
	}

	/**
	 * This method is for validateRoomType
	 * 
	 * @param option is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public String validateRoomType(int option) {

		return validations.roomType(option);
	}

	/**
	 * This method is for validate Room Status
	 * 
	 * @param option is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public String validateRoomStatus(int option) {

		return validations.roomStatus(option);
	}

	/**
	 * This method is for validate Availabilities
	 * 
	 * @param option is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public String validateAvailabilities(int option) {

		return validations.availabilities(option);
	}

	/**
	 * This method is for validate Option1
	 * 
	 * @param option is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public boolean validateOption1(String option) {
		if (option != null) {
			return validations.option1(option);
		} else {
			return false;
		}
	}

}
