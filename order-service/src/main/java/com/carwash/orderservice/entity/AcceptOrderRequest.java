package com.carwash.orderservice.entity;

import java.util.Date;

public class AcceptOrderRequest {

	private int orderId;
	private int washerId;
	private Date scheduledDate;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getWasherId() {
		return washerId;
	}
	public void setWasherId(int washerId) {
		this.washerId = washerId;
	}
	public Date getScheduledDate() {
		return scheduledDate;
	}
	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
}
