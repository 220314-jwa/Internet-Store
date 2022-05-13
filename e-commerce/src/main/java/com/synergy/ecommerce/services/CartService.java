package com.synergy.ecommerce.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergy.ecommerce.entities.Cart;
import com.synergy.ecommerce.entities.Customer;
import com.synergy.ecommerce.repositories.CartRepository;
@Service
public class CartService {
	private final CartRepository cartRepository ;
	
	@Autowired
	public CartService(CartRepository cartRepository) {
		
		this.cartRepository = cartRepository;
		
	}
	public Cart getCart(Long id){
		return cartRepository.getById(id);
	}

	public void addNewCart(Cart cart) {
		
	Optional<Cart> cartOptional = cartRepository.findById(cart.getId());
	if(cartOptional.isPresent()) {
		throw new IllegalStateException("email taken");
	}
	cartRepository.save(cart);
	System.out.println(cart);
		
	}
	
	public void deleteCart(Long id) {
		boolean exists = cartRepository.existsById(id);
		if(!exists) {
			throw new IllegalStateException("Cart with id" + id + " does not exist");
		}
		cartRepository.deleteById(id);
		
	}
	
		
	

	@Transactional
	public void updateCart(Long cartId, Integer quantity, Double totalcost, Customer customer 
			) {
		
		Cart cart = cartRepository.findById(cartId)
				.orElseThrow(() -> new IllegalStateException("Cart with id" + cartId + " does not exists!"));
		
		 
			cart.setId(cartId);;
			cart.setQuantity(quantity);
			cart.setTotalcost(totalcost);
			cart.setCustomer(customer);
			
		
		
		
	}

}
