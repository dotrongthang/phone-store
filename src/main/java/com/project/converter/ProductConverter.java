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
		return result;
	}
}
