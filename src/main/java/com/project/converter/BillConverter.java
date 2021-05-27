package com.project.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dto.BillDTO;
import com.project.entity.BillEntity;
import com.project.repository.ProductRepository;
import com.project.repository.UserRepository;

@Component
public class BillConverter {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;

	public BillEntity toEntity( BillDTO dto) {
		BillEntity result = new BillEntity();
		result.setAmount(1L);
		result.setProduct(productRepository.findOne(dto.getProductId()));
		result.setUser(userRepository.findOne(dto.getUserId()));
		result.setStatus("Đang chờ xử lý");
		return result;
	}
	
	public BillDTO toDto(BillEntity entity) {
		BillDTO result = new BillDTO();
		result.setId(entity.getId());
		result.setAmount(entity.getAmount());
		result.setProductId(entity.getProduct().getId());
		result.setUserId(entity.getUser().getId());
		result.setStatus(entity.getStatus());
		return result;
	}
}
