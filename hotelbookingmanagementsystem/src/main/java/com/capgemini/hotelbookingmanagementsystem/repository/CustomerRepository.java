package com.capgemini.hotelbookingmanagementsystem.repository;

import java.util.*;

import com.capgemini.hotelbookingmanagementsystem.bean.Address;
import com.capgemini.hotelbookingmanagementsystem.bean.Customer;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;

public class CustomerRepository {

	public static List<Customer> list = new ArrayList<Customer>();

	public static List<Customer> customerRepository() {

		Customer customer1 = HotelFactory.getCustomer();
		Address address1 = HotelFactory.getAddress();
		customer1.setCustomerName("dikshith");
		customer1.setCustomerPhnno(9505514745l);
		customer1.setCustomerEmail("dikshith@gmail.com");
		customer1.setCustomerAdhaarNo(212121212121l);
		customer1.setCustomerAge(23);
		customer1.setCustomerPassword("dikshu@123");
		address1.setHNo("1-4-143/198");
		address1.setStreet("A N Reddy Colony");
		address1.setCity("Nirmal");
		address1.setState("Telangana");
		customer1.setAddress(address1);
		list.add(customer1);

		Customer customer2 = HotelFactory.getCustomer();
		Address address2 = HotelFactory.getAddress();
		customer2.setCustomerName("Sachin");
		customer2.setCustomerPhnno(9505514745l);
		customer2.setCustomerEmail("sachin@gmail.com");
		customer2.setCustomerAdhaarNo(212121212121l);
		customer2.setCustomerAge(23);
		customer2.setCustomerPassword("sachin@123");
		address2.setHNo("1-4-122/198");
		address2.setStreet("Basvangudi");
		address2.setCity("Bangalore");
		address2.setState("Karnataka");
		customer2.setAddress(address2);
		list.add(customer2);

		return list;

	}

}
