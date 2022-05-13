package com.synergy.ecommerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergy.ecommerce.entities.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Optional<Customer> findCustomerByEmail(String email);
	Optional<Customer> findCustomerByUsername(String username);
	
}
