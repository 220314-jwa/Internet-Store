package com.synergy.ecommerce.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergy.ecommerce.entities.Category;
import com.synergy.ecommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findProductById(Long id);
	
	List<Product> findProductsByCategory(Long id);

	Product findProductByCode(String name);
	
	Product findProductByPrice(Double id);
}
