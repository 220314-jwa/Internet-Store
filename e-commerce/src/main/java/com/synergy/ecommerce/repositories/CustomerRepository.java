package com.synergy.ecommerce.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.synergy.ecommerce.entities.Customer;

import exceptions.IncorrectCredentialsException;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Optional<Customer> findCustomerByEmail(String email);
	Optional<Customer> findCustomerByUsername(String username);
	Customer login(String username, String password) throws IncorrectCredentialsException;
	Customer getCustomerById(Long id);
	Customer updateCustomer(Long customerId, String firstName, String lastName, String email, String address,
			String password, Long phoneNumber,String username);
	Customer deleteCustomer(Long id);	
	List<Customer> getCustomers();
	
	
}
