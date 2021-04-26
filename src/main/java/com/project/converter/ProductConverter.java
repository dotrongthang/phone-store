package com.project.converter;

import org.springframework.stereotype.Component;

import com.project.dto.ProductDTO;
import com.project.entity.ProductEntity;

@Component
public class ProductConverter {

	public ProductDTO toDto(ProductEntity entity) {
		ProductDTO result = new ProductDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setImage(entity.getImage());
		result.setPrice(entity.getPrice());
		result.setSold(entity.getSold());
		result.setDescription(entity.getDescription());
		result.setColor(entity.getColor());
		result.setCount(entity.getCount());
		result.setCategoryCode(entity.getCategory().getCode());
		return result;
	}
	
	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity result = new ProductEntity();
		result.setName(dto.getName());
		result.setImage(dto.getImage());
		result.setPrice(dto.getPrice());
		result.setSold(dto.getSold());
		result.setDescription(dto.getDescription());
		result.setColor(dto.getColor());
		result.setCount(dto.getCount());
		return result;
	}
	
	public ProductEntity toEntity(ProductEntity result, ProductDTO dto) {
		result.setName(dto.getName());
		result.setImage(dto.getImage());
		result.setPrice(dto.getPrice());
		result.setSold(dto.getSold());
		result.setDescription(dto.getDescription());
		result.setColor(dto.getColor());
		result.setCount(dto.getCount());
		return result;
	}
}
