package com.capgemini.hotelbookingmanagementsystem.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;
import com.capgemini.hotelbookingmanagementsystem.repository.HotelRepository;

public class AdminOperationsDaoImpl implements AdminOperationsDao {

	/**
	 * This method is for admin login
	 * 
	 * @param email    is the first parameter to validteAdmin
	 * @param password is the second parameter to validteAdmin
	 * @return method is true or false
	 */
	@Override
	public boolean login(String email, String password) {

		return email.equals("admin@gmail.com") && password.equals("admin@123");

	}

	/**
	 * This method is for Add Hotel
	 * 
	 * @param hotel is parameter to take input of reference variable
	 * @return method is true or false
	 */
	@Override
	public boolean addHotel(Hotel hotel) {
		int size = HotelRepository.hotelRoomList.size();
		HotelRepository.hotelRoomList.put(hotel, new ArrayList<Room>());

		HotelRepository.hotelBookingList.put(hotel.getHotelId(), new ArrayList<Room>());
		return size == (HotelRepository.hotelRoomList.size() - 1);
	}

	/**
	 * This method is for Delete Hotel
	 * 
	 * @param hotelid is parameter to take input of Hotelid
	 * @return method is true or false
	 */
	@Override
	public boolean deleteHotel(int hotelId) {
		int count = 0;
		Iterator<Hotel> hotelItr = HotelRepository.hotelRoomList.keySet().iterator();

		while (hotelItr.hasNext()) {
			Hotel hotel = hotelItr.next();
			if (hotelId == hotel.getHotelId()) {
				count++;
				HotelRepository.hotelRoomList.keySet().remove(hotel);
				break;
			}
		}

		return count != 0;

	}

	/**
	 * This method is to Select Hotel using HotelId
	 * 
	 * @param hotelid is parameter as input
	 * @return method is true or false
	 */
	@Override
	public boolean getHotelId(int hotelId) {
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
	 * This method is for Update Hotel
	 * 
	 * @param hotelid is first parameter to take hotelid as input
	 * @param hotel   is second parameter to take input of reference variable
	 * @return method is true or false
	 */
	@Override
	public boolean updateHotel(int hotelId, Hotel hotel) {
		int count = 0;
		Iterator<Hotel> hotelitr = HotelRepository.hotelRoomList.keySet().iterator();
		while (hotelitr.hasNext()) {
			Hotel hotel1 = hotelitr.next();
			if (hotelId == hotel1.getHotelId()) {
				count++;

			}

		}

		return count != 0;
	}

	/**
	 * This method is for Add Room
	 * 
	 * @param hotelid is first parameter to take hotelid as input
	 * @param room    is second parameter to take input of reference variable
	 * @return method is true or false
	 */
	@Override
	public boolean addRoom(int hotelId, Room room) {
		int count = 0;
		Iterator<Hotel> hotelitr = HotelRepository.hotelRoomList.keySet().iterator();
		while (hotelitr.hasNext()) {
			Hotel hotel1 = hotelitr.next();
			if (hotelId == hotel1.getHotelId()) {

				ArrayList<Room> addRoom1 = new ArrayList<Room>(HotelRepository.hotelRoomList.get(hotel1));
				int size = addRoom1.size();

				addRoom1.add(room);
				HotelRepository.hotelRoomList.put(hotel1, addRoom1);
				int n = HotelRepository.hotelRoomList.get(hotel1).size();
				int noOfRooms = n + 1;
				hotel1.setNoOfRooms(noOfRooms);

				if (size == (addRoom1.size() - 1)) {
					count++;
				}

			}
		}

		return count != 0;
	}

	/**
	 * This method is for delete room
	 * 
	 * @param hotelid is parameter to take hotelid as input
	 * @return method is true or false
	 */
	@Override
	public boolean deleteRoom(int hotelId, String roomNo) {
		int count = 0;
		Iterator<Hotel> itr = HotelRepository.hotelRoomList.keySet().iterator();
		while (itr.hasNext()) {
			Hotel hotel1 = itr.next();
			if (hotelId == hotel1.getHotelId()) {
				count++;

				ArrayList<Room> room = new ArrayList<Room>(HotelRepository.hotelRoomList.get(hotel1));

				for (Room room1 : room) {

					if (roomNo.equals(room1.getRoomNo())) {
						count++;
						room.remove(room1);
						HotelRepository.hotelRoomList.put(hotel1, room);
						int n = HotelRepository.hotelRoomList.get(hotel1).size();
						int noOfRooms = n - 1;
						hotel1.setNoOfRooms(noOfRooms);
						break;
					}

				}

			}

		}

		return count == 2;

	}

	/**
	 * This method is for update room
	 * 
	 * @param hotelid is parameter to take hotelid as input
	 * @return method is true or false
	 */
	@Override
	public boolean updateRoom(int hotelId, String roomNo, Room room) {
		int count = 0;
		Iterator<Hotel> hotelItr = HotelRepository.hotelRoomList.keySet().iterator();
		while (hotelItr.hasNext()) {
			Hotel hotel1 = hotelItr.next();
			if (hotelId == hotel1.getHotelId()) {

				Iterator<Room> itr = HotelRepository.hotelRoomList.get(hotel1).iterator();
				while (itr.hasNext()) {
					Room room1 = itr.next();
					if (roomNo.equals(room1.getRoomNo())) {
						count++;

					}
				}
			}
		}

		return count != 0;
	}

	/**
	 * This method is for getRoom
	 * 
	 * @param hotelid is parameter to take hotelid as input
	 * @param roomNo  is parameter as input
	 * @return method is Room
	 */
	@Override
	public Room getHotelRoom(int hotelId, String roomNo) {

		Iterator<Hotel> hotelitr = HotelRepository.hotelRoomList.keySet().iterator();
		while (hotelitr.hasNext()) {
			Hotel hotel1 = hotelitr.next();
			if (hotelId == hotel1.getHotelId()) {
				Iterator<Room> itr = HotelRepository.hotelRoomList.get(hotel1).iterator();
				while (itr.hasNext()) {
					Room room = itr.next();
					if (roomNo.equals(room.getRoomNo())) {
						return room;
					}
				}
			}
		}
		return null;
	}

	/**
	 * This method is for bookings By Date
	 * 
	 * @param LocalDate is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public List<Room> bookingsByDate(LocalDate ld) {
		ArrayList<Room> bySpecificDate = new ArrayList<Room>();
		for (Room room : HotelRepository.bookingStatus) {
			if (ld.equals(room.getFrom())) {
				bySpecificDate.add(room);
			}

		}
		return bySpecificDate;

	}

	/**
	 * This method is for hotelGuestName
	 * 
	 * @param hotelID is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public List<String> hotelGuestName(int hotelID) {
		ArrayList<String> name = new ArrayList<String>();

		Iterator<Hotel> hotelitr = HotelRepository.hotelRoomList.keySet().iterator();
		while (hotelitr.hasNext()) {
			Hotel hotel1 = hotelitr.next();
			if (hotelID == hotel1.getHotelId()) {

				ArrayList<Room> rooms = new ArrayList<Room>(HotelRepository.hotelRoomList.get(hotel1));

				for (Room room : rooms) {
					if (room.getRoomStatus().equals("reserved")) {
						name.add(room.getGuestName());
					}
				}

			}
		}

		return name;

	}

	/**
	 * This method is for specific Hotel Booking List
	 * 
	 * @param hotelID is parameter to take input
	 * @return method is true or false
	 */
	@Override
	public List<Room> specificHotelBookingList(int hotelID) {
		ArrayList<Room> specificHotelList = new ArrayList<Room>();

		Iterator<Hotel> hotelitr = HotelRepository.hotelRoomList.keySet().iterator();
		while (hotelitr.hasNext()) {
			Hotel hotel1 = hotelitr.next();
			if (hotelID == hotel1.getHotelId()) {
				ArrayList<Room> rooms = new ArrayList<Room>(HotelRepository.hotelRoomList.get(hotel1));

				for (Room room : rooms) {
					if (room.getRoomStatus().equals("reserved")) {
						specificHotelList.add(room);
					}
				}

			}
		}

		return specificHotelList;
	}

	/**
	 * This methods for get Room
	 * 
	 * @param hotel  is the first parameter as input
	 * @param roomNo is the second parameter as input
	 * @return method is true or false
	 */
	@Override
	public boolean getAdminRoom(Hotel hotel, String roomNo) {
		int count = 0;
		for (Room room : HotelRepository.hotelRoomList.get(hotel)) {

			if (roomNo.equals(room.getRoomNo())) {
				count++;

			}
		}
		return count != 0;
	}

}
