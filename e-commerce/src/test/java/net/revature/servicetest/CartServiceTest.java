package net.revature.servicetest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.synergy.ecommerce.*;
import com.synergy.ecommerce.entities.Cart;

import com.synergy.ecommerce.repositories.CartRepository;
import com.synergy.ecommerce.repositories.CategoryRepository;
import com.synergy.ecommerce.repositories.CustomerRepository;
import com.synergy.ecommerce.repositories.OrderRepository;
import com.synergy.ecommerce.repositories.ProductRepository;
import com.synergy.ecommerce.services.CartService;


@SpringBootTest(classes=ECommerceApplication.class)

public class CartServiceTest {
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
	private CartService cartService;

	@Test
	public void exampleTest() {
		assertTrue(true);
	}
	@Test
	public void getCarts() {
		List<Cart> carts = new ArrayList<>();
		Cart mockCart1 = new Cart();
		carts.add(mockCart1);
		Cart mockCart2 = new Cart();
	
		carts.add(mockCart2);
	
		when(cartRepository.findAll()).thenReturn(carts);

		List<Cart> cartsService = cartService.getCarts();

		assertEquals(cartsService.size(),carts.size());
		System.out.println(carts.get(0));
	}

	@Test
	public void getCartById() {

		Cart mockCart = new Cart();
		mockCart.setId(1L);
		mockCart.setQuantity(0);
		// call the method we are testing
		when(cartRepository.getById(1L)).thenReturn(mockCart);

		Cart cart = cartService.getCartById(mockCart.getId());
		// the assertion
		assertEquals(mockCart.getQuantity(), cart.getQuantity());
		System.out.println(cart.getQuantity());

	}
}

/*
	@Test
	public void getCartByCustomerId() {
		List<Cart> carts = new ArrayList<>();
		Cart mockCart1 = new Cart();
		carts.add(mockCart1);
		Cart mockCart2 = new Cart();
		carts.add(mockCart2);
		Customer customer = new Customer();
		customer.setUsername("hend");
		customer.setId(1L);
		mockCart1.setCustomer(customer);
		when(cartRepository.findCartByCustomerId(mockCart1.getCustomer().getId())).thenReturn(carts);

		List<Cart> cartsService = cartService.getCartByCustomerId(mockCart1.getCustomer().getId());

		assertEquals(cartsService.size(),carts.size());
		System.out.println(customer.getUsername());
	}
}	
*/
		
	
