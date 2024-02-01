package com.carwash.orderservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.carwash.orderservice.entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer>{

	@Query("{customerId:?0}")
	List<Order> getOrdersByCustomerId(int customerId);
	
	@Query("{orderId:?0}")
	Order getOrderByOrderId(int orderId);
	
	@Query("{washerId:?0}")
	List<Order> getOrdersByWasherId(int washerId);
	
	@Query("{carId:?0}")
	List<Order> getOrdersByCarId(int carId);

	@Query("{orderStatus:?0}")
	List<Order> getOrdersByOrderStatus(String orderStatus);
}
