package com.capgemini.hotelbookingmanagementsystem.bean;

import java.io.Serializable;

/**
 * This class is about {@link Address}
 * 
 * @author Admin
 *
 */

public class Address implements Serializable {

	private static final long serialVersionUID = 3832571180757288039L;
	private String hNo;
	private String street;
	private String city;
	private String state;

	public Address() {

	}

	public Address(String hNo, String street, String city, String state) {
		super();
		this.hNo = hNo;
		this.street = street;
		this.city = city;
		this.state = state;
	}

	public String getHNo() {
		return hNo;
	}

	public void setHNo(String hNo) {
		this.hNo = hNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address :\n     HNo=" + hNo + "\n     street=" + street + "\n     city=" + city + "\n     state="
				+ state + "\n";
	}

}
