package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.converter.UserConverter;
import com.project.dto.UserDTO;
import com.project.entity.RoleEntity;
import com.project.repository.RoleRepository;
import com.project.repository.UserRepository;
import com.project.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public UserDTO save(UserDTO dto) {
		List<RoleEntity> roles = new ArrayList<>();
		roles.add(roleRepository.findOneByCode("USER"));
		userRepository.save(userConverter.toEntity(dto, roles));
		return dto;
	}

}