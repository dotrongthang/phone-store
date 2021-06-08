package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.BillEntity;

@EnableJpaAuditing
@EnableJpaRepositories
public interface BillRepository extends JpaRepository<BillEntity, Long> {
	
	long countByStatus(int status);
	
	@Modifying
	@Transactional
	@Query(value ="SELECT * FROM bill WHERE status = ? LIMIT ? , ?", nativeQuery = true)
	List<BillEntity> findByStatusAndLimit(int status, int offset, int limit);
	
	@Modifying
	@Transactional
	@Query(value ="UPDATE bill SET status = 1 WHERE id = ?", nativeQuery = true)
	void updateBill(Long id);
	
}
