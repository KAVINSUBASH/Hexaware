package com.java.ecom.test;

import static org.junit.Assert.*;

import com.java.ecom.dao.CustomerDaoImpl;
import com.java.ecom.model.Customer;
import com.java.ecom.model.Gender;
import com.java.ecom.util.ConnectionHelper;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

public class CustomerDaoImplTest {

    private static CustomerDaoImpl customerDao;

    @BeforeClass
    public static void setUp() throws Exception {
        customerDao = new CustomerDaoImpl();
        ConnectionHelper.getConnection();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        if (ConnectionHelper.getConnection() != null) {
            ConnectionHelper.getConnection().close();
        }
    }

    @Test
    public void testAddCustomerWithGivenDetails() throws ClassNotFoundException, SQLException {
        Customer customer = new Customer();
        customer.setFirstName("Kavinsubash");
        customer.setLastName("k r");
        customer.setEmail("kavinsubash@gmail.com");
        customer.setPassword("123");
        customer.setPhone("123455");
        customer.setGender(Gender.Male);
        customer.setAddress("Kunnathur");
        customer.setCity("Tiruppur");
        customer.setState("Tamil Nadu");
        customer.setPostalCode("638103");
        customer.setCountry("India");

        int rowsAdded = customerDao.addCustomer(customer);
        assertEquals(1, rowsAdded);
    }

    @Test
    public void testAuthenticateWithGivenDetails() throws ClassNotFoundException, SQLException {
        String email = "john.doe@example.com";
        String password = "password123";
        int result = customerDao.authenticate(email, password);
        assertEquals(1, result);	
    }

    @Test
    public void testSearchByCustomerUsername() throws ClassNotFoundException, SQLException {
        String email = "kavin@gmail.com";
        Customer customer = customerDao.searchByCustomerUsername(email);
        assertNotNull(customer);
        assertEquals("kavin", customer.getFirstName());
        assertEquals("k r", customer.getLastName());
        assertEquals(email, customer.getEmail());
        assertEquals("6374424213", customer.getPhone());
    }
}
