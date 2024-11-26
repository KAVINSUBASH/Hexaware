package com.java.ecom.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import com.java.ecom.dao.OrdersDaoImpl;
import com.java.ecom.model.Orders;
import com.java.ecom.util.ConnectionHelper;

public class OrdersDaoImplTest {

	static OrdersDaoImpl ordersDao;
	@BeforeClass
    public static void setUp() throws Exception {
        ordersDao = new OrdersDaoImpl();
        ConnectionHelper.getConnection();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        if (ConnectionHelper.getConnection() != null) {
            ConnectionHelper.getConnection().close();
        }
    }

    @Test
    public void testShowOrdersDao() throws SQLException, ClassNotFoundException {
        List<Orders> ordersList = ordersDao.showOrdersDao();
        assertNotNull(ordersList);
        assertTrue(ordersList.size() > 0);
    }

    @Test
    public void testShowOrdersMoreThanDao() throws SQLException, ClassNotFoundException {
        List<Orders> ordersList = ordersDao.showOrdersMoreThanDao();
        assertNotNull(ordersList);
        assertTrue(ordersList.stream().allMatch(order -> order.getTotalPrice() > 100));
    }

    @Test
    public void testPlaceOrder() throws SQLException, ClassNotFoundException {
        Orders newOrder = new Orders();
        newOrder.setCustomerId(1);
        newOrder.setTotalPrice(250.0);
        newOrder.setShippingAddress("123 Test Street, Test City, Test Country");
        boolean isOrderPlaced = ordersDao.placeOrder(newOrder);
        assertTrue(isOrderPlaced);
    }
}
