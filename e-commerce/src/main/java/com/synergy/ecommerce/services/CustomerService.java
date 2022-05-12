package com.synergy.ecommerce.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergy.ecommerce.entities.Customer;
import com.synergy.ecommerce.repositories.CustomerRepository;

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

	public void addNewCustomer(Customer customer) {
		
	Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
	if(customerOptional.isPresent()) {
		throw new IllegalStateException("email taken");
	}
	customerRepository.save(customer);
	System.out.println(customer);
		
	}
	
	public void deleteCustomer(Long id) {
		boolean exists = customerRepository.existsById(id);
		if(!exists) {
			throw new IllegalStateException("Student with id" + id + " does not exist");
		}
		customerRepository.deleteById(id);
		
	}

	@Transactional
	public void updateCustomer(Long customerId, String firstName, String lastName, String email, String address,
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
		
		
	}
}
