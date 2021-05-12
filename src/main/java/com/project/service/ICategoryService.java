package com.project.service;

import java.util.List;
import java.util.Map;

import com.project.dto.CategoryDTO;
import com.project.entity.CategoryEntity;

public interface ICategoryService {
	Map<String, String> findAll();
	
	List<CategoryDTO> findAllDTO();
	
	CategoryEntity findOneByCode(String code);
}
