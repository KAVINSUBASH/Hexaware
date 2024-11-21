package com.java.ecom.dao;

import com.java.ecom.model.Cart;
import com.java.ecom.util.ConnectionHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {

    @Override
    public int addToCart(Cart cart) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO cart (customer_id, product_id, quantity) VALUES (?, ?, ?)";
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, cart.getCustomerId());
        stmt.setInt(2, cart.getProductId());
        stmt.setInt(3, cart.getQuantity());
        return stmt.executeUpdate();
    }

    @Override
    public int updateCart(Cart cart) throws SQLException, ClassNotFoundException {
        String query = "UPDATE cart SET quantity = ? WHERE cart_id = ?";
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, cart.getQuantity());
        stmt.setInt(2, cart.getCartId());
        return stmt.executeUpdate();
    }

    @Override
    public Cart searchByCartId(int cartId) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM cart WHERE cart_id = ?";
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, cartId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            int customerId = rs.getInt("customer_id");
            int productId = rs.getInt("product_id");
            int quantity = rs.getInt("quantity");
            return new Cart(cartId, customerId, productId, quantity);
        }
        return null;
    }

}
