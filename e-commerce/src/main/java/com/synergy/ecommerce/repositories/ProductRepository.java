package com.synergy.ecommerce.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.synergy.ecommerce.entities.Category;
import com.synergy.ecommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findProductById(Long id);
	
	List<Product> findProductsByCategory(Long id);

	Product findProductByCode(String name);
	
	Product findProductByPrice(Double id);
	
	Product updateProduct(Long id, String name, Double price, String code, Date prodDate, Category category);

	Product deleteProduct(Long id);
	
	Product addNewProduct(Product product);
	
	Product getProductById(Long id);
	
}
