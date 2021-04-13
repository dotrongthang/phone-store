package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.converter.ProductConverter;
import com.project.dto.ProductDTO;
import com.project.entity.ProductEntity;
import com.project.repository.ProductRepository;
import com.project.service.IProductService;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO save(ProductDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		
	}

}
