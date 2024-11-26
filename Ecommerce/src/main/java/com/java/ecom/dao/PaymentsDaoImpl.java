package com.java.ecom.dao;

import com.java.ecom.model.Payments;
import com.java.ecom.util.ConnectionHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PaymentsDaoImpl implements PaymentsDao {
    Connection connection;
    PreparedStatement pst;

    @Override
    public Payments showPaymentDetailsByOrderId(int orderId) throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();
        String cmd = "SELECT * FROM payments WHERE order_id = ?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, orderId);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            Payments payment = new Payments();
            payment.setPaymentId(rs.getInt("payment_id"));
            payment.setOrderId(rs.getInt("order_id"));
            payment.setPaymentMethod(rs.getString("payment_method"));
            payment.setTransactionId(rs.getString("transaction_id"));
            payment.setPaymentStatus(rs.getString("payment_status"));
            payment.setPaymentDate(rs.getTimestamp("payment_date").toString());
            return payment;
        }
        return null;
    }
    @Override
    public Payments showPaymentDetailsById(int paymentId) throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();
        String cmd = "SELECT * FROM payments WHERE payment_id = ?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, paymentId);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            Payments payment = new Payments();
            payment.setPaymentId(rs.getInt("payment_id"));
            payment.setOrderId(rs.getInt("order_id"));
            payment.setPaymentMethod(rs.getString("payment_method"));
            payment.setTransactionId(rs.getString("transaction_id"));
            payment.setPaymentStatus(rs.getString("payment_status"));
            payment.setPaymentDate(rs.getTimestamp("payment_date").toString());
            return payment;
        }
        return null;
    }
    @Override
    public boolean addPayment(Payments payment) throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();
        String cmd = "INSERT INTO payments (order_id, payment_method, transaction_id, payment_status) VALUES (?, ?, ?, ?)";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, payment.getOrderId());
        pst.setString(2, payment.getPaymentMethod());
        pst.setString(3, payment.getTransactionId());
        pst.setString(4, payment.getPaymentStatus());
        return pst.executeUpdate() > 0;
    }
    @Override
    public boolean updatePayment(Payments payment) throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();
        String cmd = "UPDATE payments SET payment_method = ?, transaction_id = ?, payment_status = ? WHERE payment_id = ?";
        pst = connection.prepareStatement(cmd);
        pst.setString(1, payment.getPaymentMethod());
        pst.setString(2, payment.getTransactionId());
        pst.setString(3, payment.getPaymentStatus());
        pst.setInt(4, payment.getPaymentId());
        return pst.executeUpdate() > 0;
    }
    @Override
    public List<Payments> showAllPendingPayments() throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();
        String cmd = "SELECT * FROM payments WHERE payment_status = 'Pending'";
        pst = connection.prepareStatement(cmd);
        ResultSet rs = pst.executeQuery();
        List<Payments> pendingPayments = new ArrayList<>();
        while (rs.next()) {
            Payments payment = new Payments();
            payment.setPaymentId(rs.getInt("payment_id"));
            payment.setOrderId(rs.getInt("order_id"));
            payment.setPaymentMethod(rs.getString("payment_method"));
            payment.setTransactionId(rs.getString("transaction_id"));
            payment.setPaymentStatus(rs.getString("payment_status"));
            payment.setPaymentDate(rs.getTimestamp("payment_date").toString());
            pendingPayments.add(payment);
        }
        return pendingPayments;
    }
    @Override
    public List<Payments> showAllCompletedPayments() throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();
        String cmd = "SELECT * FROM payments WHERE payment_status = 'Completed'";
        pst = connection.prepareStatement(cmd);
        ResultSet rs = pst.executeQuery();
        List<Payments> completedPayments = new ArrayList<>();
        while (rs.next()) {
            Payments payment = new Payments();
            payment.setPaymentId(rs.getInt("payment_id"));
            payment.setOrderId(rs.getInt("order_id"));
            payment.setPaymentMethod(rs.getString("payment_method"));
            payment.setTransactionId(rs.getString("transaction_id"));
            payment.setPaymentStatus(rs.getString("payment_status"));
            payment.setPaymentDate(rs.getTimestamp("payment_date").toString());
            completedPayments.add(payment);
        }
        return completedPayments;
    }

}
