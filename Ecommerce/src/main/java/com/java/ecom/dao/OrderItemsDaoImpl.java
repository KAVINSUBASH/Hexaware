package com.java.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.ecom.model.OrderItems;
import com.java.ecom.util.ConnectionHelper;

public class OrderItemsDaoImpl implements OrderItemsDao{
	
	Connection connection;
	PreparedStatement pst;

	@Override
	public List<OrderItems> showOrderItemsDao() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Order_Items";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<OrderItems> orderItemsList = new ArrayList<OrderItems>();
		OrderItems orderItems = null;
		
		while(rs.next()) {
			orderItems = new OrderItems();
			orderItems.setOrderItemId(rs.getInt("order_item_id"));
			orderItems.setOrderId(rs.getInt("order_id"));
			orderItems.setProdId(rs.getInt("product_id"));
			orderItems.setQuantity(rs.getInt("quantity"));
			
			orderItemsList.add(orderItems);
		}
		return orderItemsList;
		
	}
	@Override
    public List<OrderItems> showOrderItemsByProduct(int productId) throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();
        String cmd = "SELECT * FROM order_items WHERE product_id = ?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, productId);
        ResultSet rs = pst.executeQuery();
        List<OrderItems> orderItemsList = new ArrayList<>();
        while (rs.next()) {
            OrderItems item = new OrderItems();
            item.setOrderItemId(rs.getInt("order_item_id"));
            item.setOrderId(rs.getInt("order_id"));
            item.setProdId(rs.getInt("product_id"));
            item.setQuantity(rs.getInt("quantity"));
            orderItemsList.add(item);
        }
        return orderItemsList;
    }

}
