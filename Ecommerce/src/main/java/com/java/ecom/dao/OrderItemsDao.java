package com.java.ecom.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.ecom.model.OrderItems;

public interface OrderItemsDao {
	
	List<OrderItems> showOrderItemsDao() throws ClassNotFoundException, SQLException;
	List<OrderItems> showOrderItemsByProduct(int productId) throws ClassNotFoundException, SQLException;
}
