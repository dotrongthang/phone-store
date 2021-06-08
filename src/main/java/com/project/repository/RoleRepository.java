package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.project.entity.RoleEntity;

@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

	RoleEntity findOneByCode(String code);
}
