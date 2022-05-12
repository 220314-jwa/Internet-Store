package com.synergy.ecommerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergy.ecommerce.entities.Cart;
import com.synergy.ecommerce.entities.Customer;

public interface CartRepository extends JpaRepository<Cart, Long>{
	//Optional<Cart> findCartById(long id);
}
