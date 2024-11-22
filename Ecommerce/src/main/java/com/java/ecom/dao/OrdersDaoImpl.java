package com.java.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.ecom.model.Orders;
import com.java.ecom.util.ConnectionHelper;

public class OrdersDaoImpl implements OrdersDao {
	
	Connection connection;
	
	PreparedStatement pst;
	@Override
	public List<Orders> showOrdersDao() throws SQLException, ClassNotFoundException {
		
		
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Orders";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Orders> ordersList = new ArrayList<Orders>();
		Orders orders = null;
		while(rs.next()) {
			orders = new Orders();
			orders.setOrderId(rs.getInt("order_id"));
			orders.setCustomerId(rs.getInt("customer_id"));
			orders.setOrderDate(rs.getDate("order_date"));
			orders.setTotalPrice(rs.getDouble("price"));
			orders.setShippingAddress(rs.getString("shipping_address"));
			
			ordersList.add(orders);
		}
		return ordersList;
		
	}
	
public List<Orders> showOrdersMoreThanDao() throws SQLException, ClassNotFoundException {
		
		
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Orders WHERE total_price > 10000";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Orders> ordersList = new ArrayList<Orders>();
		Orders orders = null;
		while(rs.next()) {
			orders = new Orders();
			orders.setOrderId(rs.getInt("order_id"));
			orders.setCustomerId(rs.getInt("customer_id"));
			orders.setOrderDate(rs.getDate("order_date"));
			orders.setTotalPrice(rs.getDouble("price"));
			orders.setShippingAddress(rs.getString("shipping_address"));
			
			ordersList.add(orders);
		}
		return ordersList;
		
	}
	
	

}
