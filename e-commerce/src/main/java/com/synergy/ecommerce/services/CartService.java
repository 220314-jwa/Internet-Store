package com.synergy.ecommerce.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import com.synergy.ecommerce.entities.Cart;
import com.synergy.ecommerce.entities.Category;
import com.synergy.ecommerce.entities.Customer;
import com.synergy.ecommerce.entities.Product;
import com.synergy.ecommerce.repositories.CartRepository;
import com.synergy.ecommerce.repositories.CustomerRepository;
import com.synergy.ecommerce.repositories.ProductRepository;
@Service
public class CartService {
	private final CartRepository cartRepository;
	//private final CustomerRepository customerRepository;
	@Autowired
	public CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	//@Autowired
	////public CartService(CustomerRepository customerRepository) {
		///this.customerRepository = customerRepository;
	//}

	public List<Cart> getCarts() {
		return cartRepository.findAll();
	}
	
	public Cart getCartById(Long id) {
		return cartRepository.getById(id);
	}
	
	
	/*
	public Customer getCartByCustomerId(Long Id) {
		return customerRepository.getById(Id);
	}
	*/
	public void addNewCart(Cart cart) {
		cartRepository.save(cart);
		System.out.println(cart);
	}

	public void deleteCart(Long id) {
		boolean exists = cartRepository.existsById(id);
		if (!exists) {
			throw new IllegalStateException("Category with id " + id + " does not exist.");
		}
		cartRepository.deleteById(id);
	}

	@Transactional
	public void updateProduct(Long id, String name, Double price, String code, Date prodDate, Category category) {
		Cart cart = cartRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Category with id " + id + " does not exist."));

		if (id != null) {
			cart.setId(id);
			cart.setCustomer(null);
			cart.setQuantity(0);
			cart.setTotalcost(0);

		}
	}
			
		
		
		
	}


