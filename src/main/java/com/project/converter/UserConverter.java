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
		result.setPhoneNumber(dto.getPhonenumber());
		result.setAddress(dto.getAddress());
		result.setStatus(1);
		result.setRoles(roles);
		return result;
	}
	
	public UserEntity toEntity(UserEntity result, UserDTO dto) {
		result.setFullName(dto.getFullname());
		result.setUserName(dto.getUsername());
		result.setPhoneNumber(dto.getPhonenumber());
		result.setAddress(dto.getAddress());
		return result;
	}
	
	public UserDTO toDto(UserEntity entity) {
		UserDTO result = new UserDTO();
		result.setId(entity.getId());
		result.setFullname(entity.getFullName());
		result.setUsername(entity.getUserName());
		result.setPhonenumber(entity.getPhoneNumber());
		result.setAddress(entity.getAddress());
		result.setPassword(entity.getPassword());
		if(entity.getStatus() == 1) {
			result.setStatus("Hoạt động");
		}else {
			result.setStatus("Không hoạt động");
		}
		
		return result;
	}
}
