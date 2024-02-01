package com.carwash.orderservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.orderservice.entity.AcceptOrderRequest;
import com.carwash.orderservice.entity.Order;
import com.carwash.orderservice.service.OrderService;
import com.carwash.orderservice.service.OrderServiceImpl;


@CrossOrigin(origins= "*" ,maxAge = 3600)
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping
	public ResponseEntity<String> addOrder(@Valid @RequestBody Order order){
		int orderId=orderService.placeOrder(order);
		return new ResponseEntity<String>("Order added ID: "+orderId,HttpStatus.OK);
	}
	
	@PostMapping("/accept")
	public ResponseEntity<String> acceptOrder(@Valid @RequestBody AcceptOrderRequest acceptOrderRequest){
		orderService.acceptOrder(acceptOrderRequest);
		return new ResponseEntity<String>("Order Accepted ",HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> updateOrder(@Valid @RequestBody Order order){
		orderService.updateOrder(order);
		return new ResponseEntity<String>("Order updated",HttpStatus.OK);
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<Order> getOrderByOrderId(@PathVariable int orderId){
		Order order=orderService.getOrderByOrderId(orderId);
		return new ResponseEntity<Order>(order,HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Order>> getAllOrders(){
		List<Order> order=orderService.getAllOrders();
		return new ResponseEntity<List<Order>>(order,HttpStatus.OK);
	}
	@DeleteMapping("/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable int orderId){
		orderService.deleteOrder(orderId);
		return new ResponseEntity<String>("Order deleted",HttpStatus.OK);
	}
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<List<Order>> getOrdersByCustomerId(@PathVariable int customerId){
		List<Order> orderList=orderService.getOrdersByCustomerId(customerId);
		return new ResponseEntity<List<Order>>(orderList,HttpStatus.OK);
	}
	@GetMapping("/washer/{washerId}")
	public ResponseEntity<List<Order>> getOrdersByWasherId(@PathVariable int washerId){
		List<Order> orderList=orderService.getOrdersByWasherId(washerId);
		return new ResponseEntity<List<Order>>(orderList,HttpStatus.OK);
	}
	@GetMapping("/car/{carId}")
	public ResponseEntity<List<Order>> getOrdersByCarId(@PathVariable int carId){
		List<Order> orderList=orderService.getOrdersByCarId(carId);
		return new ResponseEntity<List<Order>>(orderList,HttpStatus.OK);
	}
	@GetMapping("/status/{orderStatus}")
	public ResponseEntity<List<Order>> getOrdersByOrderStatus(@PathVariable String orderStatus){
		List<Order> orderList=orderService.getOrdersByOrderStatus(orderStatus);
		return new ResponseEntity<List<Order>>(orderList,HttpStatus.OK);
	}
}
