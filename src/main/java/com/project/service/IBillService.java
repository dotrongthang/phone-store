package com.project.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.project.dto.BillDTO;

public interface IBillService {

	BillDTO save(BillDTO dto);
	List<BillDTO> findAllByWaiting(int offset, int limit);
	List<BillDTO> findAllByDone(int offset, int limit);
	int getTotalItem(); 
	int getTotalItemDone(); 
	void delete(long[] ids);
	void update(long[] ids);
}
