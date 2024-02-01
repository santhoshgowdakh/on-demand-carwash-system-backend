package com.carwash.orderservice.service;

import java.util.List;

import com.carwash.orderservice.entity.AcceptOrderRequest;
import com.carwash.orderservice.entity.Order;

public interface OrderService {

	int placeOrder(Order order);
	void updateOrder(Order order);
	Order getOrderByOrderId(int orderId);
	List<Order> getAllOrders();
	void deleteOrder(int orderId);
	List<Order> getOrdersByCustomerId(int customerId);
	List<Order> getOrdersByWasherId(int washerId);
	List<Order> getOrdersByCarId(int carId);
	List<Order> getOrdersByOrderStatus(String orderStatus);
	void acceptOrder(AcceptOrderRequest acceptOrderRequest);
}
