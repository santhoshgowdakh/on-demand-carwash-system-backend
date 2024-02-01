package com.carwash.orderservice.entity;



import java.util.Date;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "order")
public class Order {
	@Transient
	public static final String SEQUENCE_NAME="order_sequense";
	@Id
	private int orderId;
	private int customerId;
	private int carId;
	private int washerId;
	private int planId;
	private String promocode;
	private double totalPrice;
	private String orderStatus;
	private String beforeWashPic;
	private String afterWashPic;
	private Date placedOn;
	private Date scheduledOn;
	private Date closedOn;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getWasherId() {
		return washerId;
	}
	public void setWasherId(int washerId) {
		this.washerId = washerId;
	}
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	
	public String getPromocode() {
		return promocode;
	}
	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getBeforeWashPic() {
		return beforeWashPic;
	}
	public void setBeforeWashPic(String beforeWashPic) {
		this.beforeWashPic = beforeWashPic;
	}
	public String getAfterWashPic() {
		return afterWashPic;
	}
	public void setAfterWashPic(String afterWashPic) {
		this.afterWashPic = afterWashPic;
	}
	public Date getPlacedOn() {
		return placedOn;
	}
	public void setPlacedOn(Date placedOn) {
		this.placedOn = placedOn;
	}
	public Date getScheduledOn() {
		return scheduledOn;
	}
	public void setScheduledOn(Date scheduledOn) {
		this.scheduledOn = scheduledOn;
	}
	public Date getClosedOn() {
		return closedOn;
	}
	public void setClosedOn(Date closedOn) {
		this.closedOn = closedOn;
	}
	
	
}
