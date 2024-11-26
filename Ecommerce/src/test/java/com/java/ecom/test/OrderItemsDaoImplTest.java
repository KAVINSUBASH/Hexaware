package com.java.ecom.test;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import com.java.ecom.dao.OrderItemsDaoImpl;
import com.java.ecom.model.OrderItems;
import com.java.ecom.util.ConnectionHelper;

public class OrderItemsDaoImplTest {

    private static OrderItemsDaoImpl orderItemsDao;

    @BeforeClass
    public static void setUp() throws Exception {
        orderItemsDao = new OrderItemsDaoImpl();
        ConnectionHelper.getConnection();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        if (ConnectionHelper.getConnection() != null) {
            ConnectionHelper.getConnection().close();
        }
    }

    @Test
    public void testShowOrderItemsDao() throws SQLException, ClassNotFoundException {
        List<OrderItems> orderItems = orderItemsDao.showOrderItemsDao();
        assertNotNull(orderItems);
        assertTrue(orderItems.size() > 0);
    }

    @Test
    public void testShowOrderItemsByProduct() throws SQLException, ClassNotFoundException {
        int productId = 1; 
        List<OrderItems> orderItems = orderItemsDao.showOrderItemsByProduct(productId);
        assertNotNull(orderItems);
        assertTrue(orderItems.size() > 0);
        assertTrue(orderItems.stream().allMatch(item -> item.getProdId() == productId));
    }
}
