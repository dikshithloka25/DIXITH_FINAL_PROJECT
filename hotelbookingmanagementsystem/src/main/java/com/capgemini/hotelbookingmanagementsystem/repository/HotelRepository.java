package com.capgemini.hotelbookingmanagementsystem.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;

public class HotelRepository {
	static ArrayList<Room> roomList1 = new ArrayList<Room>();
	static ArrayList<Room> roomList2 = new ArrayList<Room>();
	static ArrayList<Room> hotelList1 = new ArrayList<Room>();
	static ArrayList<Room> hotelList2 = new ArrayList<Room>();
	public static Map<Hotel, ArrayList<Room>> hotelRoomList = new HashMap<Hotel, ArrayList<Room>>();
	public static List<Room> bookingStatus = new ArrayList<Room>();
	public static Map<Integer, ArrayList<Room>> hotelBookingList = new HashMap<Integer, ArrayList<Room>>();

	public static Map<Hotel, ArrayList<Room>> hotelRepository() {

		Hotel hotel1 = HotelFactory.getHotel();
		hotel1.setHotelId(1001);
		hotel1.setHotelName("Taj Krishna");
		hotel1.setHotelAddress("Hyderabad");
		hotel1.setNoOfRooms(3);
		hotel1.setDescription("5* hotel");
		hotel1.setPassword("taj@12345");

		Room room1 = HotelFactory.getRoom();
		room1.setRoomNo("taj01");
		room1.setRoomPrice(960);
		room1.setRoomStatus("available");
		room1.setRoomType("Single bedroom");
		String[] r1 = { "A/C", "FREE WIFI", "TV" };
		room1.setAvailabilities(r1);
		room1.setFrom(null);
		room1.setTo(null);
		room1.setGuestName(null);
		roomList1.add(room1);

		Room room2 = HotelFactory.getRoom();
		room2.setRoomNo("taj02");
		room2.setRoomPrice(999);
		room2.setRoomStatus("available");
		room2.setRoomType("Double bedroom");
		String[] r2 = { "COOLER", "FREE WIFI", "TV" };
		room2.setAvailabilities(r2);
		room2.setFrom(null);
		room2.setTo(null);
		room2.setGuestName(null);
		roomList1.add(room2);

		Room room5 = HotelFactory.getRoom();
		room5.setRoomNo("taj03");
		room5.setRoomPrice(1290);
		room5.setRoomStatus("reserved");
		room5.setRoomType("Double bedroom");
		String[] r5 = { "A/C", "FREE WIFI", "TV" };
		room5.setAvailabilities(r5);
		room5.setFrom(LocalDate.now());
		room5.setTo(LocalDate.now());
		room5.setGuestName("Sathish Reddy");
		roomList1.add(room5);
		bookingStatus.add(room5);
		hotelList1.add(room5);

		Hotel hotel2 = HotelFactory.getHotel();
		hotel2.setHotelId(1002);
		hotel2.setHotelName("Mayuri Hotel");
		hotel2.setHotelAddress("Nirmal");
		hotel2.setNoOfRooms(3);
		hotel2.setDescription("3* hotel");
		hotel2.setPassword("mayuri@123");

		Room room3 = HotelFactory.getRoom();
		room3.setRoomNo("myu01");
		room3.setRoomPrice(1800);
		room3.setRoomStatus("available");
		room3.setRoomType("Triple bedroom");
		String[] r3 = { "COOLER", "FREE WIFI", "TV" };
		room3.setAvailabilities(r3);
		room3.setFrom(null);
		room3.setTo(null);
		room3.setGuestName(null);
		roomList2.add(room3);

		Room room4 = HotelFactory.getRoom();
		room4.setRoomNo("myu02");
		room4.setRoomPrice(1090);
		room4.setRoomStatus("reserved");
		room4.setRoomType("Double bedroom");
		String[] r4 = { "FREE WIFI", "TV", "COOLER" };
		room4.setAvailabilities(r4);
		room4.setFrom(LocalDate.now());
		room4.setTo(LocalDate.now());
		room4.setGuestName("Akshith Reddy");
		roomList2.add(room4);
		bookingStatus.add(room4);
		hotelList2.add(room4);
		Room room6 = HotelFactory.getRoom();
		room6.setRoomNo("myu03");
		room6.setRoomPrice(799);
		room6.setRoomStatus("available");
		room6.setRoomType("Single bedroom");
		String[] r6 = { "A/C", "FREE WIFI", "TV" };
		room6.setAvailabilities(r6);
		room6.setFrom(null);
		room6.setTo(null);
		room6.setGuestName(null);
		roomList2.add(room6);

		hotelRoomList.put(hotel2, roomList2);
		hotelRoomList.put(hotel1, roomList1);
		hotelBookingList.put(1001, hotelList1);
		hotelBookingList.put(1002, hotelList2);
		return hotelRoomList;

	}

}
