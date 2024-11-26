package com.java.ecom.test;

import static org.junit.Assert.*;
import com.java.ecom.dao.CartDaoImpl;
import com.java.ecom.model.Cart;
import com.java.ecom.util.ConnectionHelper;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

public class CartDaoImplTest {

    private static CartDaoImpl cartDao;

    @BeforeClass
    public static void setUp() throws Exception {
        cartDao = new CartDaoImpl();
        ConnectionHelper.getConnection();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        if (ConnectionHelper.getConnection() != null) {
            ConnectionHelper.getConnection().close();
        }
    }

    @Test
    public void testAddToCart() throws SQLException, ClassNotFoundException {
        Cart cart = new Cart();
        cart.setCustomerId(1);
        cart.setProductId(3);
        cart.setQuantity(2);
        int rowsInserted = cartDao.addToCart(cart);
        assertEquals(1, rowsInserted);
    }

    @Test
    public void testUpdateCart() throws SQLException, ClassNotFoundException {
        Cart cart = new Cart();
        cart.setCartId(1);
        cart.setQuantity(5);
        int rowsUpdated = cartDao.updateCart(cart);
        assertEquals(1, rowsUpdated);
    }

    @Test
    public void testSearchByCartId() throws SQLException, ClassNotFoundException {
        int cartId = 1;
        Cart cart = cartDao.searchByCartId(cartId);
        assertNotNull(cart);
        assertEquals(cartId, cart.getCartId());
    }
}
