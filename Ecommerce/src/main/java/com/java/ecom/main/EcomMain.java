package com.java.ecom.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.ecom.dao.CustomerDao;
import com.java.ecom.dao.CustomerDaoImpl;
import com.java.ecom.model.Customer;

public class EcomMain {

    static Scanner sc = new Scanner(System.in);
    static CustomerDao customerDao = new CustomerDaoImpl();

    public static void customerShow() throws ClassNotFoundException, SQLException {
        List<Customer> customerList = customerDao.showCustomerDao();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    public static void searchCustomer() throws ClassNotFoundException, SQLException {
        int customerId;
        System.out.println("Enter Customer Id ");
        customerId = sc.nextInt();
        Customer customer = customerDao.searchByCustomerId(customerId);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("*** Customer Record Not Found ***");
        }
    }

    public static void searchCustomerByUsername() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Customer Username (Email): ");
        sc.nextLine();
        String email = sc.nextLine();

        Customer customer = customerDao.searchByCustomerUsername(email);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("*** Customer Record Not Found ***");
        }
    }

    public static void authenticateCustomer() throws ClassNotFoundException, SQLException {
    	sc.nextLine();
        System.out.println("Enter Customer Email: ");
        String email = sc.nextLine();
        System.out.println("Enter Customer Password: ");
        String password = sc.nextLine();

        int c = customerDao.authenticate(email, password);
        if (c>0) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed. Invalid email or password.");
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Customer Show");
            System.out.println("2. Customer Search by ID");
            System.out.println("3. Customer Search by Email");
            System.out.println("4. Customer Authentication");
            System.out.println("Enter Your Choice ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    try {
                        customerShow();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        searchCustomer();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        searchCustomerByUsername();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        authenticateCustomer();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        } while (choice != 5);
    }
}