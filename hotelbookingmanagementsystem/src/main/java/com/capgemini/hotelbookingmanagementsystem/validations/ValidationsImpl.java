package com.capgemini.hotelbookingmanagementsystem.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is about all the validations.
 * 
 * @author Admin
 *
 */
public class ValidationsImpl implements Validations {

	Pattern pattern;
	Pattern pattern1;
	Matcher matcher;
	Matcher matcher1;

	/**
	 * This methods is for Customer Name validation
	 * 
	 * @param name is parameter to validate name
	 * @return method is true or false
	 */

	@Override
	public boolean customerName(String name) {

		pattern = Pattern.compile("[a-zA-Z]+[\\s[[a-zA-Z]+]]*");
		matcher = pattern.matcher(name);

		return matcher.matches();

	}

	/**
	 * This methods is for Customer Address validation
	 * 
	 * @param address is parameter to validate Address
	 * @return method is true or false
	 */
	@Override
	public boolean customerAddress(String address) {
		pattern = Pattern.compile("[a-zA-Z0-9,.]+[\\s[[a-zA-Z0-9,.]+]]*");
		matcher = pattern.matcher(address);
		return matcher.matches();

	}

	/**
	 * This methods is for Customer Phone Number validation
	 * 
	 * @param phnno is parameter to validate Phone Number
	 * @return method is true or false
	 */
	@Override
	public boolean customerPhnno(String phnNo) {
		pattern = Pattern.compile("[6-9][0-9]{9}");
		matcher = pattern.matcher(phnNo);
		return matcher.matches();

	}

	/**
	 * This methods is for Customer Email validation
	 * 
	 * @param email is parameter to validate Email
	 * @return method is true or false
	 */
	@Override
	public boolean customerEmail(String email) {

		pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
		matcher = pattern.matcher(email);
		return matcher.matches();

	}

	/**
	 * This methods is for Customer Aadhaar Number validation
	 * 
	 * @param adhaar is parameter to validate Aadhaar Number
	 * @return method is true or false
	 */
	@Override
	public boolean customerAdhaar(String adhaar) {
		pattern = Pattern.compile("[[\\d]&&[^a-z]]{12}");
		matcher = pattern.matcher(adhaar);
		return matcher.matches();

	}

	/**
	 * This methods is for Customer Age validation
	 * 
	 * @param age is parameter to validate Age
	 * @return method is true or false
	 */
	@Override
	public boolean customerAge(String age) {
		pattern = Pattern.compile("[[\\d]&&[^a-z]]{2}");
		matcher = pattern.matcher(age);
		pattern1 = Pattern.compile("[2-9][0-9]");
		matcher1 = pattern1.matcher(age);
		if (matcher.matches()) {

			return matcher1.matches();

		} else {
			return false;
		}

	}

	/**
	 * This methods is for Customer Password validation
	 * 
	 * @param password is parameter to validate Password
	 * @return method is true or false
	 */
	@Override
	public boolean customerPassword(String password) {
		pattern = Pattern.compile("[[a-zA-Z][@!#$%^&*]{1,}[0-9]{1,}]{8,16}");
		matcher = pattern.matcher(password);
		return matcher.matches();

	}

	/**
	 * This methods is for option validation
	 * 
	 * @param option is parameter to validate option
	 * @return method is true or false
	 */
	@Override
	public boolean option1(String option) {

		pattern = Pattern.compile("[1-5&&[^a-z]]{1}");
		matcher = pattern.matcher(option);
		return matcher.matches();
	}

	/**
	 * This methods is for option1 validation
	 * 
	 * @param option1 is parameter to validate option1
	 * @return method is true or false
	 */
	@Override
	public boolean option2(String option1) {

		pattern = Pattern.compile("[1-3&&[^a-z]]{1}");
		matcher = pattern.matcher(option1);
		return matcher.matches();
	}

	/**
	 * This methods is for Date validation
	 * 
	 * @param date is parameter to validate Date
	 * @return method is true or false
	 */
	@Override
	public boolean date(String date) {

		pattern = Pattern.compile("[0-9]{4}-(0[1-9]|1[0-2])-(3[0-1]|[1-2][0-9]|0[0-9])");

		matcher = pattern.matcher(date);

		return matcher.matches();
	}

	/**
	 * This methods is for hotelID validation
	 * 
	 * @param hotelId is parameter to validate hotelID
	 * @return method is true or false
	 */
	@Override
	public boolean hotelId(String hotelId) {

		pattern = Pattern.compile("[0-9&&[^a-z]]{4}");
		matcher = pattern.matcher(hotelId);
		return matcher.matches();
	}

	/**
	 * This methods is for Room Number validation
	 * 
	 * @param roomNo is parameter to validate Address
	 * @return method is true or false
	 */
	@Override
	public boolean roomNumber(String roomNo) {
		pattern = Pattern.compile("[a-zA-Z]{3}[0-9]{2}");
		matcher = pattern.matcher(roomNo);
		return matcher.matches();

	}

	/**
	 * This methods is for option2 validation
	 * 
	 * @param option2 is parameter to validate option2
	 * @return method is true or false
	 */
	@Override
	public boolean option3(String option2) {
		pattern = Pattern.compile("[1-4&&[^a-z]]{1}");
		matcher = pattern.matcher(option2);
		return matcher.matches();

	}

	/**
	 * This methods is for hotel Name validation
	 * 
	 * @param hotelname is parameter to validate hotelName
	 * @return method is true or false
	 */
	@Override
	public boolean hotelName(String hotelName) {
		pattern = Pattern.compile("[a-zA-Z0-9]+[\\s[[a-zA-Z0-9]+]]*");
		matcher = pattern.matcher(hotelName);
		return matcher.matches();
	}

	/**
	 * This methods is for hotel Description validation
	 * 
	 * @param Desc is parameter to validate hotel Description
	 * @return method is true or false
	 */
	@Override
	public boolean hotelDescription(String description) {
		pattern = Pattern.compile("[0-9][*]" + "\\s" + "[a-zA-Z]+");
		matcher = pattern.matcher(description);
		return matcher.matches();
	}

	/**
	 * This methods is for Room price validation
	 * 
	 * @param price is parameter to validate Room price
	 * @return method is true or false
	 */
	@Override
	public boolean roomPrice(String price) {

		pattern = Pattern.compile("[0-9&&[^a-z]]{1,4}");
		matcher = pattern.matcher(price);
		return matcher.matches();
	}

	/**
	 * This methods is for Room Type validation
	 * 
	 * @param option is parameter to validate Room Type
	 * @return method is true or false
	 */
	@Override
	public String roomType(int option) {

		switch (option) {
		case 1:
			return "Single bedroom";

		case 2:
			return "Double bedroom";

		case 3:
			return "Triple bedroom";

		default:
			return null;
		}

	}

	/**
	 * This methods is for Room Status validation
	 * 
	 * @param option is parameter to validate Room Status
	 * @return method is true or false
	 */
	@Override
	public String roomStatus(int option) {
		switch (option) {
		case 1:
			return "available";

		case 2:
			return "reserved";

		case 3:
			return "Under Maintenance";

		default:
			return null;
		}
	}

	/**
	 * This methods is for customer HNo validation
	 * 
	 * @param hno is parameter to validate customer HNo
	 * @return method is true or false
	 */
	@Override
	public boolean customerHNo(String hNo) {

		pattern = Pattern.compile("[a-zA-Z0-9-/]+");
		matcher = pattern.matcher(hNo);
		return matcher.matches();

	}

	/**
	 * This methods is for hotel Address validation
	 * 
	 * @param hotelAdd is parameter to validate hotel Address
	 * @return method is true or false
	 */
	@Override
	public boolean hotelAddress(String hotelAdd) {
		pattern = Pattern.compile("[a-zA-Z0-9]+[\\,[\\s[a-zA-Z0-9]+]]*");
		matcher = pattern.matcher(hotelAdd);
		return matcher.matches();

	}

	/**
	 * This methods is for Availabilities validation
	 * 
	 * @param availables is parameter to validate Availabilities
	 * @return method is true or false
	 */
	@Override
	public String availabilities(int availables) {
		switch (availables) {
		case 1:
			return "FREE WIFI";

		case 2:
			return "TV";
		case 3:
			return "COOLER";
		case 4:
			return "A/C";
		default:
			return null;
		}

	}

}
