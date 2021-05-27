package com.project.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.BillDTO;
import com.project.service.IBillService;

@RestController(value = "billAPIOfWeb")
public class BillAPI {

	@Autowired
	private IBillService billService;
	
	@PostMapping("/api/bill")
	public BillDTO createBill(@RequestBody BillDTO billDTO) {
		return billService.save(billDTO);
	}
}
