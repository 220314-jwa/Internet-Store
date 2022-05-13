package com.synergy.ecommerce.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergy.ecommerce.entities.Cart;
import com.synergy.ecommerce.entities.Customer;
import com.synergy.ecommerce.entities.Product;

public interface CartRepository extends JpaRepository<Cart, Long>{
Optional<Cart> findCartById(Long id);
	
List<Cart> findCartsById(Long id);

//Cart findCartByCustomerId(Long id);
	

}
