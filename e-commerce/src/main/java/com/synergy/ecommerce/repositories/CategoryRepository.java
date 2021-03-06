package com.synergy.ecommerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergy.ecommerce.entities.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Optional<Category> findCategoryById(Long id);
	
	Category findCategoryByName(String Name);
	
	Category findCategoryByDesc(String Description);
}
