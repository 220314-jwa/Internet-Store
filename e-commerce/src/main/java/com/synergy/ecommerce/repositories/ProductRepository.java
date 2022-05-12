package com.synergy.ecommerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergy.ecommerce.entities.Category;
import com.synergy.ecommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findProductById(Long id);
}
