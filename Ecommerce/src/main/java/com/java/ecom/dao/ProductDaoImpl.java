package com.java.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.ecom.model.Product;
import com.java.ecom.util.ConnectionHelper;

public class ProductDaoImpl implements ProductDao {

    Connection connection;
    PreparedStatement pst;

    @Override
    public List<Product> showProducts() throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();
        String sql = "SELECT * FROM products";
        pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        List<Product> productList = new ArrayList<>();
        Product product = null;

        while (rs.next()) {
            product = new Product();
            product.setProductId(rs.getInt("product_id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setDescription(rs.getString("description"));
            product.setStockQuantity(rs.getInt("stockQuantity"));
            productList.add(product);
        }
        connection.close();
        return productList;
    }

    @Override
    public Product searchByProductId(int productId) throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();
        String sql = "SELECT * FROM products WHERE product_id = ?";
        pst = connection.prepareStatement(sql);
        pst.setInt(1, productId);
        ResultSet rs = pst.executeQuery();

        Product product = null;
        if (rs.next()) {
            product = new Product();
            product.setProductId(rs.getInt("product_id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setDescription(rs.getString("description"));
            product.setStockQuantity(rs.getInt("stockQuantity"));
        }
        connection.close();
        return product;
    }

    @Override
    public int addProduct(Product product) throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();
        String sql = "INSERT INTO products (name, price, description, stockQuantity) VALUES (?, ?, ?, ?)";
        pst = connection.prepareStatement(sql);

        pst.setString(1, product.getName());
        pst.setDouble(2, product.getPrice());
        pst.setString(3, product.getDescription());
        pst.setInt(4, product.getStockQuantity());

        int rowsAffected = pst.executeUpdate();
        connection.close();
        return rowsAffected;
    }

    @Override
    public int updateProductStock(int productId, int newStock) throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();
        String sql = "UPDATE products SET stockQuantity = ? WHERE product_id = ?";
        pst = connection.prepareStatement(sql);
        pst.setInt(1, newStock);
        pst.setInt(2, productId);

        int rowsAffected = pst.executeUpdate();
        connection.close();
        return rowsAffected;
    }

    @Override
    public int deleteProduct(int productId) throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();
        String sql = "DELETE FROM products WHERE product_id = ?";
        pst = connection.prepareStatement(sql);
        pst.setInt(1, productId);

        int rowsAffected = pst.executeUpdate();
        connection.close();
        return rowsAffected;
    }
}
