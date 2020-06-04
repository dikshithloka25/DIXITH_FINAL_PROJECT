package com.capgemini.hotelbookingmanagementsystem.validations;

public interface Validations {
	public boolean customerName(String name);

	public boolean customerAddress(String address);

	public boolean customerPhnno(String phnNo);

	public boolean customerEmail(String email);

	public boolean customerAdhaar(String adhaar);

	public boolean customerAge(String age);

	public boolean customerPassword(String password);

	public boolean customerHNo(String hNo);

	public boolean option1(String option);

	public boolean option2(String option1);

	public boolean option3(String option2);

	public boolean date(String date);

	public boolean hotelId(String hotelId);

	public boolean hotelName(String hotelName);

	public boolean hotelDescription(String description);

	public boolean hotelAddress(String hotelAddress);

	public boolean roomNumber(String roomNo);

	public boolean roomPrice(String price);

	public String roomType(int option);

	public String roomStatus(int option);

	public String availabilities(int availables);
}
