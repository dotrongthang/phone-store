package com.project.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.converter.CategoryConverter;
import com.project.dto.CategoryDTO;
import com.project.entity.CategoryEntity;
import com.project.repository.CategoryRepository;
import com.project.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryConverter categoryConverter;
	
	@Override
	public Map<String, String> findAll() {
		Map<String, String> result = new HashMap<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for(CategoryEntity item: entities) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}


	@Override
	public List<CategoryDTO> findAllDTO() {
		List<CategoryDTO> dto = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for(CategoryEntity item: entities) {
			dto.add(categoryConverter.toDto(item));
		}
		return dto;
	}


	@Override
	public CategoryEntity findOneByCode(String code) {
		CategoryEntity entity = categoryRepository.findOneByCode(code);
		return entity;
	}

}