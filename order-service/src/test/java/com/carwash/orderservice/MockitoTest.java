package com.carwash.orderservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.carwash.orderservice.entity.Order;
import com.carwash.orderservice.exception.NotFoundException;
import com.carwash.orderservice.service.OrderService;
import com.carwash.orderservice.service.OrderServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
	@Mock
	OrderService orderService;

	@InjectMocks
	OrderServiceImpl orderServiceImpl;
	
	private Order order;
	
	@Before
	public void setup() {
		order=new Order();
		order.setOrderId(30006);
		order.setCarId(30001);
		order.setCustomerId(10001);
		order.setPlanId(401);
		order.setPromocode("CARWASH40");
	}


	@Test(expected=NotFoundException.class)
	public void testPlaceOrder_notFoundException() {
		when(orderService.placeOrder(order)).thenThrow(NotFoundException.class);			
			orderService.placeOrder(order);
		
	}
	
	@Test
	public void testPlaceOrder(){
		when(orderService.placeOrder(order)).thenReturn(order.getOrderId());
		assertEquals(30006, orderService.placeOrder(order));
	}
	@Test
	public void testGetOrder(){
		when(orderService.getOrderByOrderId(anyInt())).thenReturn(order);
		assertEquals(30006, orderService.getOrderByOrderId(3).getOrderId());
	}
	
	@Test
	public void testGetOrdersByCarId(){
		List<Order> list=mock(List.class);
		when(orderService.getOrdersByCarId(10001)).thenReturn(list);	
		assertEquals(0, orderService.getOrdersByCarId(10001).size());
	}
	@Test
	public void testGetOrdersByCustomerId(){
		List<Order> list=mock(List.class);
		when(orderService.getOrdersByCustomerId(10001)).thenReturn(list);	
		assertEquals(0, orderService.getOrdersByCustomerId(10001).size());
	}
	@Test(expected = NotFoundException.class)
	public void testGetOrdersByCustomerId_exception(){
		List<Order> list=mock(List.class);
		when(orderService.getOrdersByCustomerId(anyInt())).thenThrow(NotFoundException.class);	
		orderService.getOrdersByCustomerId(1);
		//assertEquals(0, orderService.getOrdersByCustomerId(10001).size());
	}
	
}
