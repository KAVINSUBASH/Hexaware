package com.java.ecom.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.ecom.model.Customer;

public interface CustomerDao {
	List<Customer> showCustomerDao() throws ClassNotFoundException, SQLException;
	Customer searchByCustomerId(int customerId) throws ClassNotFoundException, SQLException ;
	Customer searchByCustomerUsername(String email) throws ClassNotFoundException,SQLException;
	int authenticate(String email, String password) throws ClassNotFoundException,SQLException;
	int addCustomer(Customer customer) throws ClassNotFoundException, SQLException;
}
