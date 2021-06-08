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
		result.setStatus(0);
		return result;
	}
	
	public BillDTO toDtoSave(BillEntity entity) {
		BillDTO result = new BillDTO();
		result.setId(entity.getId());
		result.setAmount(entity.getAmount());
		result.setProductId(entity.getProduct().getId());
		result.setUserId(entity.getUser().getId());
		return result;
	}
	
	public BillDTO toDto(BillEntity entity) {
		BillDTO result = new BillDTO();
		if(entity.getStatus() == 0) {
			result.setStatusOfBill("Đang chờ xử lý");
		}else {
			result.setStatusOfBill("Đã xử lý");
		}
		result.setId(entity.getId());
		result.setAmount(entity.getAmount());
		result.setProductId(entity.getProduct().getId());
		result.setUserId(entity.getUser().getId());
		
		result.setProductName(entity.getProduct().getName());
		result.setProductColor(entity.getProduct().getColor());
		result.setProductSold(entity.getProduct().getSold());
		result.setCustomerName(entity.getUser().getFullName());
		result.setCreatedDate(entity.getCreatedDate());
		result.setPhoneNumber(entity.getUser().getPhoneNumber());
		result.setAddress(entity.getUser().getAddress());
		return result;
	}
}
