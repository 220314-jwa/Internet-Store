package com.synergy.ecommerce.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergy.ecommerce.entities.Customer;
import com.synergy.ecommerce.repositories.CustomerRepository;

import exceptions.IncorrectCredentialsException;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository ;
	
	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		
		this.customerRepository = customerRepository;
		
	}
	
	public List<Customer> getCustomers(){
		return customerRepository.findAll();
	}

	public Customer addNewCustomer(Customer customer) {
		
	Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
	if(customerOptional.isPresent()) {
		throw new IllegalStateException("email taken");
	}
	customerRepository.save(customer);
	System.out.println(customer);
	return customer;
		
	}
	
	public void deleteCustomer(Long id) {
		boolean exists = customerRepository.existsById(id);
		if(!exists) {
			throw new IllegalStateException("Student with id" + id + " does not exist");
		}
		customerRepository.deleteById(id);
		
	}

	@Transactional
	public Customer updateCustomer(Long customerId, String firstName, String lastName, String email, String address,
			String password, Long phoneNumber,String username) {
		
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new IllegalStateException("Customer with id" + customerId + " does not exists!"));
		
		if(email!=null && email.length()>0) {
			customer.setEmail(email);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setAddress(address);
			customer.setPassword(password);
			customer.setPhoneNumber(phoneNumber);
			customer.setUsername(password);
			customer.setUsername(username);
			
		}
	
		return customer;
		
		
	}
	
	public Customer login(String username, String password) throws IncorrectCredentialsException {
		Optional<Customer> customerOptional = customerRepository.findCustomerByUsername(username);		
		if(customerOptional.isPresent()) {
			
			if(password.equals(customerOptional.get().getPassword())) {
				
				System.out.println("You logged in!");
				return customerOptional.get();
			}
			else {
				throw new IncorrectCredentialsException();
			}	
			
		}else {
			
			throw new IncorrectCredentialsException();
			
		}
		

	}


	public Customer getCustomerById(Long id) {
		Customer customer = customerRepository.getCustomerById(id);
	return customer;
}

}