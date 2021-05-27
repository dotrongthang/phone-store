package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.BillEntity;

public interface BillRepository extends JpaRepository<BillEntity, Long> {

}
