package com.project.service;

import java.util.List;

import com.project.dto.UserDTO;

public interface IUserService {

	UserDTO save(UserDTO dto);
	List<UserDTO> findAll();
}
