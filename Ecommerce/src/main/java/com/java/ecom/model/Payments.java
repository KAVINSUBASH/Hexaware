package com.java.ecom.model;

public class Payments {
    private int paymentId;
    private int orderId;
    private String paymentMethod;
    private String transactionId;
    private String paymentStatus;
    private String paymentDate;

    public Payments() {
    }

    public Payments(int paymentId, int orderId, String paymentMethod, String transactionId, String paymentStatus, String paymentDate) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
    }

    public Payments(int orderId, String paymentMethod, String transactionId, String paymentStatus, String paymentDate) {
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payments [paymentId=" + paymentId + ", orderId=" + orderId + ", paymentMethod=" + paymentMethod
                + ", transactionId=" + transactionId + ", paymentStatus=" + paymentStatus + ", paymentDate="
                + paymentDate + "]";
    }
}
