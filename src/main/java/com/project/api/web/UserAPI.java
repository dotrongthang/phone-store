package com.project.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.ProductDTO;
import com.project.dto.UserDTO;
import com.project.service.IUserService;

@RestController(value = "userAPIOfWeb")
public class UserAPI {
	
	@Autowired
	private IUserService userService;

	@PostMapping("/api/user")
	public UserDTO register(@RequestBody UserDTO userDTO) {
		return userService.save(userDTO);
	}
	
	@PutMapping("/api/user")
	public UserDTO updateUser(@RequestBody UserDTO updateUser) {	
		return userService.save(updateUser);
	}
}
