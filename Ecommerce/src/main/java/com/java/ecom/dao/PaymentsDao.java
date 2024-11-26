package com.java.ecom.dao;

import com.java.ecom.model.Payments;
import java.sql.SQLException;
import java.util.*;

public interface PaymentsDao {
    Payments showPaymentDetailsByOrderId(int orderId) throws ClassNotFoundException, SQLException;
    Payments showPaymentDetailsById(int paymentId) throws ClassNotFoundException, SQLException;
    boolean addPayment(Payments payment) throws ClassNotFoundException, SQLException;
    boolean updatePayment(Payments payment) throws ClassNotFoundException, SQLException;
    List<Payments> showAllPendingPayments() throws ClassNotFoundException, SQLException;
    List<Payments> showAllCompletedPayments() throws ClassNotFoundException, SQLException;
}
