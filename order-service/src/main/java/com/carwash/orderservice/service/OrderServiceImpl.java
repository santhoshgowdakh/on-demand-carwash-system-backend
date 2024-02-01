package com.carwash.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.carwash.orderservice.entity.AcceptOrderRequest;
import com.carwash.orderservice.entity.Order;
import com.carwash.orderservice.exception.NotFoundException;
import com.carwash.orderservice.exception.OrderAlreadyExistsException;
import com.carwash.orderservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	SequenseGeneratorService sequenseGeneratorService;

	@Override
	public int placeOrder(Order order) {
		if(!restTemplate.getForObject("http://plan-service/plan/exists/"+order.getPlanId(), Boolean.class))
			throwNotFoundException("Plan");
		if(!restTemplate.getForObject("http://user-service/user/exists/"+order.getCustomerId(), Boolean.class))
			throwNotFoundException("Customer");
		if(!restTemplate.getForObject("http://car-service/car/exists/"+order.getCarId(), Boolean.class))
			throwNotFoundException("Car");
		try {
		if(getOrdersByCarId(order.getCarId()).stream().filter(o->(o.getOrderStatus().equals("complete")==false)).toList().size()!=0)
			throw new OrderAlreadyExistsException("Wash order already placed for this car");
		}catch(NotFoundException n) {
			
		}
		if(order.getPromocode()!=null||order.getPromocode()!="")
		if(!restTemplate.getForObject("http://promocode-service/promocode/exists/"+order.getPromocode(), Boolean.class))
			throwNotFoundException("Promocode");
		order.setOrderStatus("open");
		order.setOrderId(sequenseGeneratorService.getSequenseNumber(order.SEQUENCE_NAME));
		orderRepository.save(order);
		return order.getOrderId();
	}

	@Override
	public void updateOrder(Order order) {
		if(!existsById(order.getOrderId()))
			throwNotFoundException("Order");
		orderRepository.save(order);
	}
	
	@Override
	public Order getOrderByOrderId(int orderId) {
		if(!orderRepository.existsById(orderId))
			throwNotFoundException("Order");
		return orderRepository.getOrderByOrderId(orderId);
	}
	@Override
	public List<Order> getAllOrders() {
		List<Order> orders=orderRepository.findAll();
		if(orders.size()==0)
			throwNotFoundException("Order");
		return orders;
	}

	@Override
	public void deleteOrder(int orderId) {
		if(!orderRepository.existsById(orderId))
			throwNotFoundException("Order");
			orderRepository.deleteById(orderId);
	}
	@Override
	public List<Order> getOrdersByCustomerId(int customerId) {
		List<Order> orderList = orderRepository.getOrdersByCustomerId(customerId);
		if(orderList.size()==0)
			throwNotFoundException("Order");
		return orderList;
	}
	@Override
	public List<Order> getOrdersByWasherId(int washerId) {
		List<Order> orderList = orderRepository.getOrdersByWasherId(washerId);
		if(orderList.size()==0)
			throwNotFoundException("Order");
		return orderList;
	}
	@Override
	public List<Order> getOrdersByCarId(int carId){
		List<Order> orderList = orderRepository.getOrdersByCarId(carId);
		if(orderList.size()==0)
			throwNotFoundException("Order");
		return orderList;
	}
	
	@Override
	public List<Order> getOrdersByOrderStatus(String orderStatus){
		List<Order> orderList = orderRepository.getOrdersByOrderStatus(orderStatus);
		if(orderList.size()==0)
			throwNotFoundException("Order");
		return orderList;
	}
	
	@Override
	public void acceptOrder(AcceptOrderRequest acceptOrderRequest) {
		Order order=getOrderByOrderId(acceptOrderRequest.getOrderId());
		order.setWasherId(acceptOrderRequest.getWasherId());
		order.setScheduledOn(acceptOrderRequest.getScheduledDate());
		order.setOrderStatus("scheduled");
		updateOrder(order);
	}
	
	public void completeOrder(AcceptOrderRequest acceptOrderRequest) {
		Order order=getOrderByOrderId(acceptOrderRequest.getOrderId());
		
		order.setClosedOn(acceptOrderRequest.getScheduledDate());
		order.setOrderStatus("completed");
		updateOrder(order);
	}
	
	public void throwNotFoundException(String s) {
		throw new NotFoundException(s+" doesnot exists.....");
	}
	
	public boolean existsById(int orderId) {
		return orderRepository.existsById(orderId);
	}
	

}
