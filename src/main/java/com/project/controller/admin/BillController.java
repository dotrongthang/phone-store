package com.project.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.converter.ProductConverter;
import com.project.converter.UserConverter;
import com.project.dto.BillDTO;
import com.project.dto.ProductDTO;
import com.project.dto.UserDTO;
import com.project.entity.ProductEntity;
import com.project.service.IBillService;
import com.project.service.ICategoryService;
import com.project.service.IProductService;
import com.project.util.MessageUtil;

@Controller(value = "billControllerOfAdmin")
public class BillController {

	@Autowired
	private IBillService billService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private ProductConverter productConverter;
	
	@RequestMapping(value = "/quan-tri/don-hang/danh-sach", method = RequestMethod.GET)
	   public ModelAndView showList(@RequestParam("page") int page, 
			   						@RequestParam("limit") int limit, HttpServletRequest request) {
		BillDTO model = new BillDTO();
		List<ProductDTO> products = new ArrayList<>();
		List<UserDTO> users = new ArrayList<>();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/bill/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(billService.findAll(pageable));
		model.setTotalItem(billService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		
		for (BillDTO item: model.getListResult()) {
			products.add(productConverter.toDto(item.getProduct()));
			users.add(userConverter.toDto(item.getUser()));
		}
		
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert",  message.get("alert"));
		}
		mav.addObject("product", products);
		mav.addObject("user", users);
		mav.addObject("model", model);
		return mav;
	   }

}
