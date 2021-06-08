package com.project.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.BillDTO;
import com.project.service.IBillService;
import com.project.util.MessageUtil;

@Controller(value = "billControllerOfAdmin")
public class BillController {

	@Autowired
	private IBillService billService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/quan-tri/don-hang/danh-sach", method = RequestMethod.GET)
	   public ModelAndView showList(@RequestParam("page") int page, 
			   						@RequestParam("limit") int limit, HttpServletRequest request) {
		BillDTO model = new BillDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/bill/listWaiting");
//		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(billService.findAllByWaiting(((int)(page -1)* limit),limit));
		model.setTotalItem(billService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));	
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert",  message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	   }

	@RequestMapping(value = "/quan-tri/don-hang/thong-ke", method = RequestMethod.GET)
	   public ModelAndView showListDone(@RequestParam("page") int page, 
			   							@RequestParam("limit") int limit,
			   							HttpServletRequest request) {
		BillDTO model = new BillDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/bill/listDone");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(billService.findAllByDone(((int)(page -1)* limit),limit));
		model.setTotalItem(billService.getTotalItemDone());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));	
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert",  message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	   }
}
