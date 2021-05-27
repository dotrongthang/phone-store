package com.project.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.IProductService;
import com.project.service.IUserService;

@RestController(value = "userAPIOfAdmin")
public class UserAPI {
	
	@Autowired
	private IUserService userService;

	@DeleteMapping("/api/user")
	public void deleteNew(@RequestBody long[] ids) {
		userService.delete(ids);
	}
}
