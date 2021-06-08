package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.project.entity.CategoryEntity;
import com.project.entity.ProductEntity;

@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	
	List<ProductEntity> findByCategory(CategoryEntity category);
	
	
	public List<ProductEntity> findByNameContaining(String name);
	
}
