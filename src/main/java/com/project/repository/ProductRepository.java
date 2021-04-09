package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
