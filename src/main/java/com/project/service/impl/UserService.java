package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.converter.UserConverter;
import com.project.dto.ProductDTO;
import com.project.dto.UserDTO;
import com.project.entity.ProductEntity;
import com.project.entity.RoleEntity;
import com.project.entity.UserEntity;
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
		UserEntity userEntity = new UserEntity();
		if(dto.getId() != null) {
			UserEntity oldUser = userRepository.findOne(dto.getId());
			userEntity = userConverter.toEntity(oldUser, dto);
		}else {
			List<RoleEntity> roles = new ArrayList<>();
			roles.add(roleRepository.findOneByCode("USER"));
			userEntity = userConverter.toEntity(dto, roles);
		}
		return userConverter.toDto(userRepository.save(userEntity));
	}

	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> models = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll();
		for(UserEntity items : entities) {
			UserDTO userDTO = userConverter.toDto(items);
			models.add(userDTO);
		}
		return models;
	}

	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		List<UserDTO> models = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll(pageable).getContent();
		for (UserEntity item: entities) {
			UserDTO userDTO = userConverter.toDto(item);
			models.add(userDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) userRepository.count();
	}

	@Override
	public void delete(long[] ids) {
		for(long id: ids) {
			userRepository.changeStatus(0, id);
		}
	}

	@Override
	public List<UserDTO> findAllAdmin() {
		List<UserDTO> models = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAllOfAdmin();
		for (UserEntity item: entities) {
			UserDTO userDTO = userConverter.toDto(item);
			models.add(userDTO);
		}
		return models;
	}

	@Override
	public UserDTO findById(Long id) {
		UserEntity entity = userRepository.findOne(id);
		return userConverter.toDto(entity);
	}

//	@Override
//	public List<UserDTO> findAll() {
//		
//	}

}
