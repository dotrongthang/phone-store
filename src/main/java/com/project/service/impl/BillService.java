package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.converter.BillConverter;
import com.project.dto.BillDTO;
import com.project.dto.ProductDTO;
import com.project.entity.BillEntity;
import com.project.entity.ProductEntity;
import com.project.repository.BillRepository;
import com.project.service.IBillService;

@Service
public class BillService implements IBillService {

	@Autowired
	private BillConverter billConverter;
	
	@Autowired
	private BillRepository billRepository;
	
	@Override
	public BillDTO save(BillDTO dto) {
		BillEntity entity = billConverter.toEntity(dto);
		return billConverter.toDtoSave(billRepository.save(entity));
	}

	@Override
	public List<BillDTO> findAllByWaiting(int offset, int limit) {
		List<BillDTO> models = new ArrayList<>();
		List<BillEntity> entities = billRepository.findByStatusAndLimit(0, offset, limit);
		for (BillEntity item: entities) {
				BillDTO billDTO = billConverter.toDto(item);
				models.add(billDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) billRepository.countByStatus(0);
	}

	@Override
	public void delete(long[] ids) {
		for(long id: ids) {
			billRepository.delete(id);
		}
		
	}

	@Override
	public List<BillDTO> findAllByDone(int offset, int limit) {
		List<BillDTO> models = new ArrayList<>();
		List<BillEntity> entities = billRepository.findByStatusAndLimit(1, offset, limit);
		for (BillEntity item: entities) {
				BillDTO billDTO = billConverter.toDto(item);
				models.add(billDTO);
		}
		return models;
	}

	@Override
	public int getTotalItemDone() {
		return (int) billRepository.countByStatus(1);
	}

	@Override
	public void update(long[] ids) {
		for(long id: ids) {
			billRepository.updateBill(id);
		}
		
	}

}
