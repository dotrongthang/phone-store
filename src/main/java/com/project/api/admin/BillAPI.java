package com.project.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.BillDTO;
import com.project.service.IBillService;

@RestController(value = "billAPIOfAdmin")
public class BillAPI {

	@Autowired
	private IBillService billService;
	
	@PutMapping("/api/bill")
	public void updateBill(@RequestBody long[] ids) {
		billService.update(ids);
	}
	
	@DeleteMapping("/api/bill")
	public void deleteBill(@RequestBody long[] ids) {
		billService.delete(ids);
	}
}
