package com.synergy.ecommerce.services;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergy.ecommerce.entities.Category;
import com.synergy.ecommerce.entities.Product;
import com.synergy.ecommerce.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getProducts() {
		return productRepository.findAll();
	}


	public Product addNewProduct(Product product) {
		System.out.println(product);
		return productRepository.save(product);
  }

	
	public Product getProductById(Long id) {
		return productRepository.getById(id);
	}
	
	public List<Product> getProductsByCategoryId(Long id){
		return productRepository.findProductsByCategory(id);
	}
	
	public Product getProductByCode(String name) {
		return productRepository.findProductByCode(name);
	}
	public Product getProductByPrice(Double id) {
		return productRepository.findProductByPrice(id);
	}
	public Product addNewProduct(Product product) {
		productRepository.save(product);
		System.out.println(product);
		return product;
	}

	public void deleteProduct(Long id) {
		boolean exists = productRepository.existsById(id);
		if (!exists) {
			throw new IllegalStateException("Category with id " + id + " does not exist.");
		}
		productRepository.deleteById(id);
	}

	@Transactional
	public Product updateProduct(Long id, String name, Double price, String code, Date prodDate, Category category) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Category with id " + id + " does not exist."));

		if (id != null) {
			product.setId(id);
			product.setName(name);
			product.setPrice(price);
			product.setCode(code);
			product.setProdDate(prodDate);
			product.setCategory(category);
			
		}
		return product;
	}
}
