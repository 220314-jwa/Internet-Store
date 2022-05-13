package com.synergy.ecommerce.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synergy.ecommerce.entities.Customer;
import com.synergy.ecommerce.services.CustomerService;

import exceptions.IncorrectCredentialsException;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins="http://localhost:4200")
public class AuthController {
	
	private final CustomerService customerService;

	@Autowired
	public AuthController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Customer>  login(@RequestBody Map<String, String> credentials) {
		
		String username = credentials.get("username");
		String password = credentials.get("password");

		try {
			Customer customer = customerService.login(username, password);
			return ResponseEntity.ok(customer);
		} catch (IncorrectCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

}
