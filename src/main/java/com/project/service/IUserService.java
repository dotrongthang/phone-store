package com.project.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.project.dto.UserDTO;

public interface IUserService {

	UserDTO save(UserDTO dto);
	UserDTO findById(Long id);
	List<UserDTO> findAll();
	List<UserDTO> findAll(Pageable pageable);
	List<UserDTO> findAllAdmin();
	int getTotalItem();
	void delete(long[] ids);
}
