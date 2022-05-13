package com.synergy.ecommerce.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.synergy.ecommerce.entities.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findOrderByOrderDate(Date orderDate);
	
	List<Order> getOrders();
	
	Order findOrderById(long Id);

	Order getByOrderStatus(String orderStatus);
	
	Order addNewOrder(Order order);
	
	
	
}
