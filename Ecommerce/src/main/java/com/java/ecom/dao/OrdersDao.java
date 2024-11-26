package com.java.ecom.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.ecom.model.Orders;

public interface OrdersDao {
	
	List<Orders> showOrdersDao() throws SQLException, ClassNotFoundException;
	List<Orders> showOrdersMoreThanDao() throws SQLException, ClassNotFoundException;
	boolean placeOrder(Orders order) throws ClassNotFoundException, SQLException;

}
