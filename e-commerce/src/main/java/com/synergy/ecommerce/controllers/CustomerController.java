package com.synergy.ecommerce.controllers;

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

import com.synergy.ecommerce.entities.Customer;
import com.synergy.ecommerce.services.CustomerService;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {
	
	private final CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService =  customerService;
	}
	
	@GetMapping
	public List<Customer> getCustomers(){
		return customerService.getCustomers();	
	}
	
	@PostMapping
	public void registerNewCustomer(@RequestBody Customer customer) {
		
		customerService.addNewCustomer(customer);
	}
	
	@DeleteMapping(path = {"/{customerId}"})
	public void deleteCustomer(@PathVariable("customerId") Long id) {
		customerService.deleteCustomer(id);
		System.out.println(id);
	}
	
	@PutMapping(path = {"{customerId}"})
	public void updateCustomer(
			@PathVariable("customerId") Long customerId,
			@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName,
			@RequestParam(required = false) String email,
			@RequestParam(required = false) String address,
			@RequestParam(required = false) String password,
			@RequestParam(required = false) String username,
			@RequestParam(required = false) Long phoneNumber) {
		
		customerService.updateCustomer(customerId,firstName,lastName,email,address,password,phoneNumber,username);
	}
	

}
