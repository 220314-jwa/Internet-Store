package com.synergy.ecommerce.controllers;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import com.synergy.ecommerce.entities.Category;
import com.synergy.ecommerce.entities.Product;
import com.synergy.ecommerce.services.ProductService;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public List<Product> getProducts() {
		return productService.getProducts();
	}

	@PostMapping
	public Product registerNewProduct(@RequestBody Product product) {
		return productService.addNewProduct(product);
	}

	@PutMapping(path = { "/id" })
	public void updateProduct(@PathVariable("id") Long id, @RequestParam(required = false) String name,
			@PathVariable("price") Double price, @RequestParam(required = false) String code,
			@RequestParam(required = false) Date prodDate, @RequestParam(required = false) Category category) {
		productService.updateProduct(id, name, price, code, prodDate, category);
	}
}
 