package com.synergy.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergy.ecommerce.entities.Image;
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
	 
}
