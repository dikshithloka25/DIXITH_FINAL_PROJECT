package com.capgemini.hotelbookingmanagementsystem.dao;

import java.util.Iterator;

import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.repository.HotelRepository;

/**
 * This class is to Validate Employee Login and Employee control operations.
 * 
 *
 */
public class EmployeeManagementDaoImpl implements EmployeeManagementDao {

	/**
	 * This methods for Employee login
	 * 
	 * @param email    is the first parameter to validateEmployee
	 * @param password is the second parameter to validateEmployee
	 * @return method is true or false
	 */

	@Override
	public boolean login(int hotelId, String password) {

		int count = 0;
		Iterator<Hotel> itr = HotelRepository.hotelRoomList.keySet().iterator();
		while (itr.hasNext()) {

			Hotel hotel = itr.next();
			if (hotelId == hotel.getHotelId() && password.equals(hotel.getPassword())) {
				count++;
			}
		}
		return count != 0;

	}

}
