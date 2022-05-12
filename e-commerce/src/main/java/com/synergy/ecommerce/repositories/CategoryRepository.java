package com.synergy.ecommerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergy.ecommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Optional<Category> findCategoryById(Long id);
}
