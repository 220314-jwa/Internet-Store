package com.synergy.ecommerce.services;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergy.ecommerce.entities.Category;
import com.synergy.ecommerce.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepository){
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> getCategory(){
		return categoryRepository.findAll();
	}
	
	public Category addNewCategory(Category category) {
		categoryRepository.save(category);
		System.out.println(category);
		return category;
	}
	
	public void deleteCategory(Long id) {
		boolean exists = categoryRepository.existsById(id);
		if(!exists) {
			throw new IllegalStateException("Category with id " + id + " does not exist.");
		}
		categoryRepository.deleteById(id);
	}
	
	@Transactional
	public void updateCategory(Long id, String name, String description) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Category with id " + id + " does not exist."));
		
		if(id!=null) {
			category.setId(id);
			category.setName(name);
			category.setDescription(description);
		}
	}
}
