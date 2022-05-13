package net.revature.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ImportResource;

import com.synergy.ecommerce.ECommerceApplication;
import com.synergy.ecommerce.entities.Order;
import com.synergy.ecommerce.repositories.CartRepository;
import com.synergy.ecommerce.repositories.CategoryRepository;
import com.synergy.ecommerce.repositories.CustomerRepository;
import com.synergy.ecommerce.repositories.OrderRepository;
import com.synergy.ecommerce.repositories.ProductRepository;
import com.synergy.ecommerce.services.OrderService;
	
	@SpringBootTest(classes=ECommerceApplication.class)
	public class OrderServiceTest {
		
		@MockBean
		private ProductRepository productRepository;
		@MockBean
		private CategoryRepository categoryRepository;
		@MockBean
		private CartRepository cartRepository;
		@MockBean
		private OrderRepository orderRepository;
		@MockBean
		private CustomerRepository customerRepository;
		
		@Autowired
		private OrderService orderServ;

		@Test
		public void exampleTest() {
			assertTrue(true);
		}
	@Test
	public void getOrderById() {
		
		Order mockOrder = new Order();
		mockOrder.setId(1L);
		mockOrder.setOrderDate(new Date());
		mockOrder.setOrderStatus("pending");
		// calling tested method
		when(orderRepository.getById(1L)).thenReturn(mockOrder);
		
		Order order = orderServ.getOrderById(mockOrder.getId());
		// assertion
		assertEquals(mockOrder.getOrderStatus(), order.getOrderStatus());
		System.out.println(order.getOrderStatus());
	}

	@Test
	public Order getOrderByOrderDate() {
		List<Order> orders = new ArrayList<>();
		Order mockOrder = new Order();
		Order mockOrder1 = new Order();
		mockOrder.setOrderDate(new Date());
		orders.add(mockOrder1);
		Order mockOrder2 = new Order();
		mockOrder.setOrderDate(new Date());
		mockOrder.setOrderStatus("Order Accepted");
		orders.add(mockOrder2);

		when(orderRepository.findOrderByOrderDate(mockOrder.getOrderDate())).thenReturn(orders);
		
		List<Order> order = orderServ.getOrderByDate(mockOrder1.getOrderDate());
		
		assertEquals(mockOrder.getOrderDate(), order.get(0));
		System.out.println(order.get(0));
		return mockOrder2;
	}

	@Test
	public void getOrderByStatus () {
		List<Order> orders = new ArrayList<>();
		Order mockOrder = new Order();
		Order mockOrder1 = new Order();
		mockOrder.setOrderDate(new Date());
		mockOrder.setOrderStatus("Order Pending");
		orders.add(mockOrder1);
		Order mockOrder2 = new Order();
		mockOrder.setId(3L);
		mockOrder.setOrderDate(new Date());
		mockOrder.setOrderStatus("Order Pending");
		orders.add(mockOrder2);
		
		when(orderRepository.getByOrderStatus(mockOrder.getOrderStatus())).thenReturn(mockOrder1);
		
		Order order = orderServ.getOrderByStatus(mockOrder.getOrderStatus());
		
		assertEquals(mockOrder1.getId(), order.getId());
		System.out.println(order.getId());
		
	}

	@Test
	public void addNewOrder () {
		Order mockOrder = new Order();
		Order newOrder = new Order();
		mockOrder.setId(5L);
		mockOrder.setOrderDate(new Date());
		mockOrder.setOrderStatus("approved");
		// calling tested method
		when(orderRepository.save(mockOrder)).thenReturn(mockOrder);
		
		Order order = orderServ.addNewOrder(mockOrder);
		
		Order result = orderServ.addNewOrder(newOrder);
		assertNotEquals(0, result.getId());

		//assertEquals(mockOrder.getId(), order.getId());
		System.out.println(order.getId());
	}
	
}
