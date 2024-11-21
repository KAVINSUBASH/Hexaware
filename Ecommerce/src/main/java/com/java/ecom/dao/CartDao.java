package com.java.ecom.dao;

import com.java.ecom.model.Cart;
import java.sql.SQLException;
import java.util.List;

public interface CartDao {
    int addToCart(Cart cart) throws SQLException, ClassNotFoundException;
    int updateCart(Cart cart) throws SQLException, ClassNotFoundException;
    Cart searchByCartId(int cartId) throws SQLException, ClassNotFoundException;
}
