package com.project.converter;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import com.project.dto.UserDTO;
import com.project.entity.RoleEntity;
import com.project.entity.UserEntity;

@Component
public class UserConverter {

	public UserEntity toEntity( UserDTO dto, List<RoleEntity> roles) {
		UserEntity result = new UserEntity();
		result.setFullName(dto.getFullname());
		result.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt(12)));
		result.setUserName(dto.getUsername());
		result.setStatus(1);
		result.setRoles(roles);
		return result;
	}
}
