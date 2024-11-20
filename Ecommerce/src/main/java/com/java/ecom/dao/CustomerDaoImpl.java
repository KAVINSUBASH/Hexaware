package com.java.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.ecom.main.EcomMain;
import com.java.ecom.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.ecom.model.Customer;
import com.java.ecom.model.Gender;
import com.java.ecom.util.ConnectionHelper;
public class CustomerDaoImpl implements CustomerDao {

    Connection connection;
    PreparedStatement pst;

    @Override
    public List<Customer> showCustomerDao() throws ClassNotFoundException, SQLException {

        connection = ConnectionHelper.getConnection();
        String cmd = "select * from Customers";
        pst = connection.prepareStatement(cmd);
        ResultSet rs = pst.executeQuery();
        List<Customer> customerList = new ArrayList<Customer>();
        Customer customer = null;

        while (rs.next()) {
            customer = new Customer();
            customer.setCustomerId(rs.getInt("customer_id"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customer.setEmail(rs.getString("email"));
            customer.setPassword(rs.getString("password")); // Assuming password is stored (remember to hash before storing)
            customer.setPhone(rs.getString("phone"));
            customer.setGender(Gender.valueOf(rs.getString("gender")));
            customer.setAddress(rs.getString("address"));
            customer.setCity(rs.getString("city"));
            customer.setState(rs.getString("state"));
            customer.setPostalCode(rs.getString("postal_code"));
            customer.setCountry(rs.getString("country"));
            customer.setRegistrationDate(rs.getDate("registration_date"));

            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public Customer searchByCustomerId(int customerId) throws ClassNotFoundException, SQLException {

        connection = ConnectionHelper.getConnection();
        String cmd = "select * from Customers WHERE customer_id = ?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, customerId);
        ResultSet rs = pst.executeQuery();
        Customer customer = null;

        while (rs.next()) {
            customer = new Customer();
            customer.setCustomerId(rs.getInt("customer_id"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customer.setEmail(rs.getString("email"));
            customer.setPassword(rs.getString("password"));
            customer.setPhone(rs.getString("phone"));
            customer.setGender(Gender.valueOf(rs.getString("gender")));
            customer.setAddress(rs.getString("address"));
            customer.setCity(rs.getString("city"));
            customer.setState(rs.getString("state"));
            customer.setPostalCode(rs.getString("postal_code"));
            customer.setCountry(rs.getString("country"));
            customer.setRegistrationDate(rs.getDate("registration_date"));
        }
        return customer;
    }

        public Customer searchByCustomerUsername(String email) throws ClassNotFoundException,SQLException {
            String sql = "SELECT * FROM customers WHERE email = ?";
            connection = ConnectionHelper.getConnection();
            pst = connection.prepareStatement(sql);
            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();
            Customer customer = null;
            if(rs.next()) {
            	customer=new Customer();
            	customer.setCustomerId(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
                customer.setPhone(rs.getString("phone"));
                customer.setGender(Gender.valueOf(rs.getString("gender")));
                customer.setAddress(rs.getString("address"));
                customer.setCity(rs.getString("city"));
                customer.setState(rs.getString("state"));
                customer.setPostalCode(rs.getString("postal_code"));
                customer.setCountry(rs.getString("country"));
                customer.setRegistrationDate(rs.getDate("registration_date"));
            }
            return customer;
        }

        public int authenticate(String email, String password) throws ClassNotFoundException,SQLException {
            String sql = "SELECT * FROM customers WHERE email = ? AND password = ?";
            connection = ConnectionHelper.getConnection();
            pst = connection.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            Customer customer = new Customer();
            int count=0;
            if(rs.next()) {
            	count=rs.getInt(1);
            }
            return count;
        }
}