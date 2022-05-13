package com.synergy.ecommerce.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergy.ecommerce.entities.Order;
import com.synergy.ecommerce.repositories.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository orderRepository ;
	
	@Autowired
	public OrderService(OrderRepository orderRepository) {
		
		this.orderRepository = orderRepository;
		
	}
	
	public List<Order> getOrders(){
		return orderRepository.findAll();
	}
	
	public Order addNewOrder(Order order) {
		
	orderRepository.save(order);
	System.out.println(order);
	return order;
	}
	
	public void deleteOrder(Long id) {
		boolean exists = orderRepository.existsById(id);
		if(!exists) {
			throw new IllegalStateException("Order with this Id" + id + "does not exist");
		}
		orderRepository.deleteById(id);
		
	}
	
	@Transactional
	public void updateOrder(Long customerId, Long orderId, Date orderDate, String orderStatus) {
		
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new IllegalStateException("Order with this ID" + orderId + "does not exist."));
		
		order.setId(orderId);
		order.setOrderDate(orderDate);
		order.setOrderStatus(orderStatus);
	}
	public Order getOrderById(Long id) {
		return orderRepository.getById(id);
	}

	public List<Order> getOrderByDate(Date orderDate) {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	public Order getOrderByStatus(String orderStatus) {
		// TODO Auto-generated method stub
		return orderRepository.getByOrderStatus(orderStatus);
	}

}
