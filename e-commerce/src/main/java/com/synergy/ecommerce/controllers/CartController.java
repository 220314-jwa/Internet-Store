package com.synergy.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synergy.ecommerce.entities.Cart;
import com.synergy.ecommerce.entities.Customer;
import com.synergy.ecommerce.services.CartService;
import com.synergy.ecommerce.services.CustomerService;

@RestController
@RequestMapping(path = "api/v1/cart")
@CrossOrigin(origins="http://localhost:4200")
public class CartController {

private final CartService cartService;
	
	@Autowired
	public CartController(CartService cartService) {
		this.cartService =  cartService;
	}
	
	@GetMapping(path = {"{cartId}"})
	public Cart getCart(@PathVariable("cartId") Long cartId
){
		return cartService.getCartById(cartId);	
	}
	
	@PostMapping
	public void registerNewCart(@RequestBody Cart cart) {
		
		cartService.addNewCart(cart);
	}
	
	@DeleteMapping(path = {"/{cartId}"})
	public void deleteCustomer(@PathVariable("cartId") Long id) {
		cartService.deleteCart(id);
		System.out.println(id);
	}
	
	/*@PutMapping(path = {"{cartId}"})
	public void updateCart(
			@PathVariable("cartId") Long cartId,
			@RequestParam(required = false) Integer quantity,
			@RequestParam(required = false) Double totalcost,
			@RequestParam(required = false) Customer customer)
			//@RequestParam(required = false) Product product,
			
			 {
		
		cartService.updateCart(cartId,quantity,totalcost,customer);
	*/}

	



