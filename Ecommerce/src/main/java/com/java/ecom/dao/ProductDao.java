package com.java.ecom.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.ecom.model.Product;

public interface ProductDao {
	List<Product> showProducts() throws ClassNotFoundException, SQLException;
	Product searchByProductId(int productId) throws ClassNotFoundException, SQLException;
	int addProduct(Product product) throws ClassNotFoundException, SQLException;
	int updateProductStock(int productId, int newStock) throws ClassNotFoundException, SQLException;
	int deleteProduct(int productId) throws ClassNotFoundException, SQLException;
}
