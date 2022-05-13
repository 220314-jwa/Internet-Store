package com.synergy.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergy.ecommerce.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
	 
}
