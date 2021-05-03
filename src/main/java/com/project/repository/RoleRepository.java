package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

	RoleEntity findOneByCode(String code);
}
