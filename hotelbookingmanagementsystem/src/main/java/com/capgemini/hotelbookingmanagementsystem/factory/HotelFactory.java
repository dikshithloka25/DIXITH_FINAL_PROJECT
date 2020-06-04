package com.capgemini.hotelbookingmanagementsystem.factory;

import com.capgemini.hotelbookingmanagementsystem.bean.Address;
import com.capgemini.hotelbookingmanagementsystem.bean.Customer;
import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;
import com.capgemini.hotelbookingmanagementsystem.controller.AdminController;
import com.capgemini.hotelbookingmanagementsystem.controller.CustomerController;
import com.capgemini.hotelbookingmanagementsystem.controller.EmployeeManagementController;
import com.capgemini.hotelbookingmanagementsystem.dao.AdminOperationsDao;
import com.capgemini.hotelbookingmanagementsystem.dao.AdminOperationsDaoImpl;

import com.capgemini.hotelbookingmanagementsystem.dao.CustomerDao;
import com.capgemini.hotelbookingmanagementsystem.dao.CustomerDaoImpl;
import com.capgemini.hotelbookingmanagementsystem.dao.EmployeeManagementDaoImpl;
import com.capgemini.hotelbookingmanagementsystem.dao.EmployeeManagementDao;

import com.capgemini.hotelbookingmanagementsystem.services.AdminServiceImpl;
import com.capgemini.hotelbookingmanagementsystem.services.CustomerService;
import com.capgemini.hotelbookingmanagementsystem.services.CustomerServiceImpl;
import com.capgemini.hotelbookingmanagementsystem.services.EmployeeManagementService;
import com.capgemini.hotelbookingmanagementsystem.services.EmployeeManagementServiceImpl;
import com.capgemini.hotelbookingmanagementsystem.validations.Validations;
import com.capgemini.hotelbookingmanagementsystem.validations.ValidationsImpl;

/**
 * This class is to Create a Factory of Objects.
 *
 */
public class HotelFactory {

	private HotelFactory() {

	}

	/**
	 * This method is to return customer object
	 * 
	 * @return method is Customer Object
	 */

	public static Customer getCustomer() {

		return new Customer();

	}

	/**
	 * This method is to return Address object
	 * 
	 * @return method is Address Object
	 */
	public static Address getAddress() {

		return new Address();
	}

	/**
	 * This method is to return Room object
	 * 
	 * @return method is Room Object
	 */
	public static Room getRoom() {

		return new Room();
	}

	/**
	 * This method is to return Hotel object
	 * 
	 * @return method is Hotel Object
	 */
	public static Hotel getHotel() {

		return new Hotel();

	}

	/**
	 * This method is to return ValidationsImpl object
	 * 
	 * @return method is ValidationsImpl Object
	 */
	public static Validations getValidations() {

		return new ValidationsImpl();

	}

	/**
	 * This method is to return CustomerDaoImpl object
	 * 
	 * @return method is CustomerDaoImpl Object
	 */
	public static CustomerDao getCustomerDaoImpl() {

		return new CustomerDaoImpl();

	}

	/**
	 * This method is to return CustomerService object
	 * 
	 * @return method is CustomerService Object
	 */
	public static CustomerService getCustomerServiceImpl() {

		return new CustomerServiceImpl();

	}

	/**
	 * This method is to return EmployeeManagementLogin object
	 * 
	 * @return method is EmployeeManagementLogin Object
	 */
	public static EmployeeManagementDao getEmployeeManagementDaoImpl() {

		return new EmployeeManagementDaoImpl();
	}

	/**
	 * This method is to return AdminService object
	 * 
	 * @return method is AdminService Object
	 */
	public static AdminServiceImpl getAdminService() {

		return new AdminServiceImpl();
	}

	/**
	 * This method is to return AdminOperationsDaoImpl object
	 * 
	 * @return method is AdminOperationsDaoImpl Object
	 */

	public static AdminOperationsDao getAdminOperationsDaoImpl() {

		return new AdminOperationsDaoImpl();

	}

	/**
	 * This method is to return CustomerController object
	 * 
	 * @return method is CustomerController Object
	 */
	public static CustomerController getCustomerController() {
		return new CustomerController();

	}
	/**
	 * This method is to return EmployeeManagementServiceImpl object
	 * 
	 * @return method is EmployeeManagementServiceImpl Object
	 */
	public static EmployeeManagementService getEmployeeManagementService() {

		return new EmployeeManagementServiceImpl();

	}
	/**
	 * This method is to return AdminController object
	 * 
	 * @return method is AdminController Object
	 */
	public static AdminController getAdminController() {
		return new AdminController();
	}
	/**
	 * This method is to return EmployeeManagementController object
	 * 
	 * @return method is EmployeeManagementController Object
	 */
	public static EmployeeManagementController getEmployeeManagementController() {
		return new EmployeeManagementController();
	}
}
