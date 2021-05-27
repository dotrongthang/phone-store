package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findOneByUserNameAndStatus(String name, int status);
	
	@Modifying
	@Transactional
	@Query(value ="UPDATE user SET status = ? WHERE id = ?", nativeQuery = true)
	public void changeStatus(Integer status, Long id);
	
	@Modifying
	@Transactional
	@Query(value ="SELECT * FROM user JOIN user_role on user.id = user_role.userid WHERE roleid = 1", nativeQuery = true)
	List<UserEntity> findAllOfAdmin();
}
