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

import com.project.dto.UserDTO;
import com.project.service.IUserService;
import com.project.util.MessageUtil;

@Controller(value = "userControllerOfAdmin")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/quan-tri/nguoi-dung/danh-sach", method = RequestMethod.GET)
	   public ModelAndView showList(@RequestParam("page") int page, 
			   						@RequestParam("limit") int limit, HttpServletRequest request) {
		UserDTO model = new UserDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/user/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(userService.findAll(pageable));
		model.setTotalItem(userService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert",  message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	   }
	
	@RequestMapping(value = "/quan-tri/nguoi-dung/danh-sach/admin", method = RequestMethod.GET)
	   public ModelAndView showListAdmin( HttpServletRequest request) {
		UserDTO model = new UserDTO();
		
		ModelAndView mav = new ModelAndView("admin/user/listAdmin");
		
		model.setListResult(userService.findAllAdmin());
		model.setTotalItem(userService.getTotalItem());
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert",  message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	   }
}
