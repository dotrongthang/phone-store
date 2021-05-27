package com.project.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.project.dto.BillDTO;

public interface IBillService {

	BillDTO save(BillDTO dto);
	List<BillDTO> findAll(Pageable pageable);
	int getTotalItem(); 
}
