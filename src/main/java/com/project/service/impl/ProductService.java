package com.project.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	public ProductDTO save(ProductDTO dto, String nameImage) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		ProductEntity productEntity = new ProductEntity();
		if (dto.getId() != null) {
			ProductEntity oldProduct = productRepository.findOne(dto.getId());
			if(dto.getImage() == null) {
				dto.setImage(nameImage);
			}
			oldProduct.setCategory(category);
			productEntity = productConverter.toEntity(oldProduct, dto);
		} else {
			dto.setImage(nameImage);
			productEntity = productConverter.toEntity(dto);
			productEntity.setCategory(category);
		}
		return productConverter.toDto(productRepository.save(productEntity));
	}
	
//	private String saveFile(MultipartFile file) {
//		if(file != null && !file.isEmpty()) {
//			try {
//				byte[] bytes = file.getBytes();
//				String rootPath = System.getProperty("catalina.home");
//				//creating the directory to store file
//				File dir = new File(rootPath+ File.separator + "assets/user/img");
//				if(!dir.exists()) {
//					dir.mkdir();
//				}
//				
//				//creating the file on server
//				String name = String.valueOf(new Date().getTime()+".jpg");
//				File serverFile = new File(dir.getAbsoluteFile() + File.separator + name);
//				//output
//				System.out.println("======== Path of image on server: " + serverFile.getPath());
//				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
//				stream.write(bytes);
//				stream.close();
//				
//				return name;
//			} catch (IOException e) {
//				
//				System.out.println("======== Error load File: " + e.getMessage());
//			}
//		}else {
//			System.out.println("======== File not exits " );
//		}
//		
//		return null;
//		}

	@Override
	public void delete(long[] ids) {
		for(long id: ids) {
			productRepository.delete(id);
		}
		
	}

	@Override
	public List<ProductDTO> findAll() {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll();
		for (ProductEntity item: entities) {
			ProductDTO newDTO = productConverter.toDto(item);
			models.add(newDTO);
		}
		return models;
	}

	@Override
	public List<ProductDTO> findByCategory(CategoryEntity category) {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findByCategory(category);
		for (ProductEntity item: entities) {
			ProductDTO newDTO = productConverter.toDto(item);
			models.add(newDTO);
		}
		return models;
	}

}
