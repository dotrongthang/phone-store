package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.project.entity.CategoryEntity;

@EnableJpaRepositories
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	CategoryEntity findOneByCode(String code);
}