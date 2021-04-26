package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.converter.ProductConverter;
import com.project.dto.ProductDTO;
import com.project.entity.CategoryEntity;
import com.project.entity.ProductEntity;
import com.project.repository.CategoryRepository;
import com.project.repository.ProductRepository;
import com.project.service.IProductService;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<ProductDTO> findAll(Pageable pageable) {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll(pageable).getContent();
		for (ProductEntity item: entities) {
			ProductDTO newDTO = productConverter.toDto(item);
			models.add(newDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) productRepository.count();
		
	}

	@Override
	public ProductDTO findById(long id) {
		ProductEntity entity = productRepository.findOne(id);
		return productConverter.toDto(entity);
	}

	@Override
	public ProductDTO save(ProductDTO dto) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		ProductEntity productEntity = new ProductEntity();
		if (dto.getId() != null) {
			ProductEntity oldProduct = productRepository.findOne(dto.getId());
			oldProduct.setCategory(category);
			productEntity = productConverter.toEntity(oldProduct, dto);
		} else {
			productEntity = productConverter.toEntity(dto);
			productEntity.setCategory(category);
		}
		return productConverter.toDto(productRepository.save(productEntity));
	}

	@Override
	public void delete(long[] ids) {
		for(long id: ids) {
			productRepository.delete(id);
		}
		
	}

}
