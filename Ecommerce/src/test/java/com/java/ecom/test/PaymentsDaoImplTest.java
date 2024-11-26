package com.java.ecom.test;

import static org.junit.Assert.*;

import com.java.ecom.dao.PaymentsDaoImpl;
import com.java.ecom.model.Payments;
import com.java.ecom.util.ConnectionHelper;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class PaymentsDaoImplTest {

    private static PaymentsDaoImpl paymentsDao;

    @BeforeClass
    public static void setUp() throws Exception {
        paymentsDao = new PaymentsDaoImpl();
        ConnectionHelper.getConnection();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        if (ConnectionHelper.getConnection() != null) {
            ConnectionHelper.getConnection().close();
        }
    }

    @Test
    public void testAddPayment() throws SQLException, ClassNotFoundException {
        Payments payment = new Payments();
        payment.setOrderId(1);
        payment.setPaymentMethod("Credit Card");
        payment.setTransactionId("TXN123456");
        payment.setPaymentStatus("Pending");
        boolean isAdded = paymentsDao.addPayment(payment);
        assertTrue(isAdded);
    }

    @Test
    public void testUpdatePayment() throws SQLException, ClassNotFoundException {
        Payments payment = new Payments();
        payment.setPaymentId(1);
        payment.setPaymentMethod("Debit Card");
        payment.setTransactionId("TXN789012");
        payment.setPaymentStatus("Completed");
        boolean isUpdated = paymentsDao.updatePayment(payment);
        assertTrue(isUpdated);
    }

    @Test
    public void testShowPaymentDetailsByOrderId() throws SQLException, ClassNotFoundException {
        int orderId = 1;
        Payments payment = paymentsDao.showPaymentDetailsByOrderId(orderId);
        assertNotNull(payment);
        assertEquals(orderId, payment.getOrderId());
    }

    @Test
    public void testShowPaymentDetailsById() throws SQLException, ClassNotFoundException {
        int paymentId = 1;
        Payments payment = paymentsDao.showPaymentDetailsById(paymentId);
        assertNotNull(payment);
        assertEquals(paymentId, payment.getPaymentId());
    }

    @Test
    public void testShowAllPendingPayments() throws SQLException, ClassNotFoundException {
        List<Payments> pendingPayments = paymentsDao.showAllPendingPayments();
        assertNotNull(pendingPayments);
        assertTrue(pendingPayments.size() > 0);
        assertTrue(pendingPayments.stream().allMatch(payment -> payment.getPaymentStatus().equals("Pending")));
    }

    @Test
    public void testShowAllCompletedPayments() throws SQLException, ClassNotFoundException {
        List<Payments> completedPayments = paymentsDao.showAllCompletedPayments();
        assertNotNull(completedPayments);
        assertTrue(completedPayments.size() > 0);
        assertTrue(completedPayments.stream().allMatch(payment -> payment.getPaymentStatus().equals("Completed")));
    }
}
