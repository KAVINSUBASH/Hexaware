package com.java.ecom.model;

public class OrderItems {
	
	private int orderItemId;
	private int orderId;
	private int prodId;
	private int quantity;
	
	public OrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItems(int orderItemId, int orderId, int prodId, int quantity) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.prodId = prodId;
		this.quantity = quantity;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItems [orderItemId=" + orderItemId + ", orderId=" + orderId + ", prodId=" + prodId + ", quantity="
				+ quantity + "]";
	}
	
	
	

}
