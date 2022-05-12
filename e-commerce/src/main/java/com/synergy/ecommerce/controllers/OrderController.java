package com.synergy.ecommerce.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synergy.ecommerce.entities.Order;
import com.synergy.ecommerce.services.OrderService;

@RestController
@RequestMapping(path = "api/v1/order")
public class OrderController {

	private final OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping
	public List<Order> getOrders() {
		return orderService.getOrders();
	}
	
	@PostMapping
	public void createNewOrder(@RequestBody Order order) {
		
		orderService.addNewOrder(order);
	}
	
	@PutMapping(path = {"{orderId}"})
	public void updateOrder(
			@PathVariable("orderId") Long orderId,
			@RequestParam(required = false) Long customerId,
			@RequestParam(required = false) Date orderDate,
			@RequestParam(required = false) String orderStatus) {
		
		orderService.updateOrder(customerId, orderId, orderDate, orderStatus);
		
	
	}

}
