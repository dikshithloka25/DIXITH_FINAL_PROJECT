package com.capgemini.hotelbookingmanagementsystem.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.capgemini.hotelbookingmanagementsystem.bean.Customer;
import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;
import com.capgemini.hotelbookingmanagementsystem.repository.CustomerRepository;
import com.capgemini.hotelbookingmanagementsystem.repository.HotelRepository;

/**
 * This class is about providing customer all the Hotels and Rooms of respective
 * Hotels available and allowing customer to reserve a Room of His Convenience
 * and also can be able to see the booking status of his own bookings only.
 *
 */
public class CustomerDaoImpl implements CustomerDao {

	public static List<Room> customerBookingList = new ArrayList<Room>();

	/**
	 * This methods for Customer Registration
	 * 
	 * @param Customer class reference as input
	 * @return method is true or false
	 */
	@Override
	public boolean customerRegistration(Customer customer) {

		int size = CustomerRepository.list.size();

		CustomerRepository.list.add(customer);

		return size == (CustomerRepository.list.size() - 1);

	}

	/**
	 * This methods for Customer login
	 * 
	 * @param email    is the first parameter to validateCustomer
	 * @param password is the second parameter to validateCustomer
	 * @return method is true or false
	 */

	public boolean login(String email, String password) {
		int count = 0;
		Iterator<Customer> itr = CustomerRepository.list.iterator();
		while (itr.hasNext()) {

			Customer customer1 = itr.next();
			if (email.equals(customer1.getCustomerEmail()) && password.equals(customer1.getCustomerPassword())) {
				count++;
			}
		}
		return count != 0;
	}

	/**
	 * This methods for getCustomerName
	 * 
	 * @param email    is the first parameter to validateCustomer
	 * @param password is the second parameter to validateCustomer
	 * @return method is String
	 */
	@Override
	public String getCustomerName(String email, String password) {

		Iterator<Customer> itr = CustomerRepository.list.iterator();
		while (itr.hasNext()) {

			Customer customer1 = itr.next();
			if (email.equals(customer1.getCustomerEmail()) && password.equals(customer1.getCustomerPassword())) {

				return customer1.getCustomerName();
			}
		}
		return null;
	}

	/**
	 * This methods for booking hotel & room in that hotel
	 * 
	 * @param hotelid is parameter to take hotelid as input
	 * @return method is true or false
	 */
	@Override
	public boolean bookingHotel(int hotelId) {

		int count = 0;

		Iterator<Hotel> itr = HotelRepository.hotelRoomList.keySet().iterator();
		while (itr.hasNext()) {
			Hotel hotel = itr.next();
			if (hotelId == hotel.getHotelId()) {
				count++;

			}
		}
		return count != 0;

	}

	/**
	 * This methods for get Hotel
	 * 
	 * @param hotelid is the parameter
	 * @return method is Hotel
	 */
	@Override
	public Hotel getHotel(int hotelId) {
		Iterator<Hotel> itr = HotelRepository.hotelRoomList.keySet().iterator();
		while (itr.hasNext()) {
			Hotel hotel = itr.next();
			if (hotelId == hotel.getHotelId()) {

				return hotel;
			}
		}
		return null;
	}

	/**
	 * This methods for Booking Room
	 * 
	 * @param hotel  is the first parameter as input
	 * @param roomNo is the second parameter as input
	 * @param from   is the third parameter as input
	 * @param to     is the fourth parameter as input
	 * @param name   is the fifth parameter as input
	 * @return method is Room
	 */
	public Room bookingRoom(Hotel hotel, String roomNo, LocalDate from, LocalDate to, String name) {

		for (Room room : HotelRepository.hotelRoomList.get(hotel)) {

			if (roomNo.equals(room.getRoomNo()) && room.getRoomStatus().equals("available")) {

				room.setFrom(from);
				room.setTo(to);
				room.setRoomStatus("reserved");

				room.setGuestName(name);
				ArrayList<Room> room1 = new ArrayList<Room>(HotelRepository.hotelBookingList.get(hotel.getHotelId()));
				room1.add(room);
				HotelRepository.hotelBookingList.put(hotel.getHotelId(), room1);
				customerBookingList.add(room);
				return room;
			}
		}

		return null;

	}

	/**
	 * This methods for get Room
	 * 
	 * @param hotel  is the first parameter as input
	 * @param roomNo is the second parameter as input
	 * @return method is true or false
	 */
	@Override
	public boolean getRoom(Hotel hotel, String roomNo) {
		int count = 0;
		for (Room room : HotelRepository.hotelRoomList.get(hotel)) {

			if (roomNo.equals(room.getRoomNo()) && room.getRoomStatus().equals("available")) {
				count++;

			}
		}
		return count != 0;
	}

	/**
	 * This methods for booking status
	 * 
	 * @exception NoRoomBookedException on input error
	 * @return method is null
	 */

	@Override
	public List<Room> bookingStatus() {

		return customerBookingList;

	}

}