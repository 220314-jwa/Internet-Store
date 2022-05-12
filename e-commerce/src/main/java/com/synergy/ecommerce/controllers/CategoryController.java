package com.synergy.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.synergy.ecommerce.entities.Category;
import com.synergy.ecommerce.services.CategoryService;

@RestController
@RequestMapping(path = "api/v1/category")
public class CategoryController {
	private final CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public List<Category> getCategory(){
		return categoryService.getCategory();
	}
	
	@PostMapping
	public void registerNewCategory(@RequestBody Category category) {
		categoryService.addNewCategory(category);
	}
	
	@DeleteMapping(path = {"/id"})
	public void updateCategory(
			@PathVariable("id") Long id,
			@RequestParam (required = false) String name,
			@RequestParam(required = false) String description) {
		categoryService.updateCategory(id, name, description);
	}
}
