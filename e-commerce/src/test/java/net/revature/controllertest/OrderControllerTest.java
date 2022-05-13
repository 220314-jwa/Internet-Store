package net.revature.controllertest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synergy.ecommerce.ECommerceApplication;
import com.synergy.ecommerce.controllers.OrderController;
import com.synergy.ecommerce.entities.Order;
import com.synergy.ecommerce.repositories.OrderRepository;
import com.synergy.ecommerce.services.OrderService;

@SpringBootTest(classes=ECommerceApplication.class)
public class OrderControllerTest {
	@MockBean
	private OrderService orderServ;
	@Autowired
	private OrderController orderController;
	@Autowired
	private WebApplicationContext context;
	@Autowired
	private OrderRepository orderRepository;
	
	private ObjectMapper jsonMapper = new ObjectMapper ();
	
	private MockMvc mockMvc;
	
	//getter and setter for product controller
	public OrderController getOrderController() {
		return orderController;
	}
	
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void createNewOrder() throws JsonProcessingException {
		Order order = new Order();
		Order mockOrder = new Order();
		
		mockOrder.setId(1L);
		mockOrder.setOrderDate(new Date());
		mockOrder.setOrderStatus("approved");
		when(orderRepository.save(order)).thenReturn(mockOrder);
	}
}
