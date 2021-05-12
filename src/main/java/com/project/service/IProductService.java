package com.project.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.project.dto.ProductDTO;
import com.project.entity.CategoryEntity;

public interface IProductService {

	List<ProductDTO> findAll(Pageable pageable);
	List<ProductDTO> findAll();
	int getTotalItem(); 
	ProductDTO findById(long id);
	ProductDTO save(ProductDTO dto, String nameImage);
	void delete(long[] ids);
	List<ProductDTO> findByCategory(CategoryEntity category);
}
