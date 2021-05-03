package com.project.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.service.ICategoryService;
import com.project.util.MessageUtil;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	   public ModelAndView homePage() {
	      ModelAndView mav = new ModelAndView("web/home");
	      mav.addObject("categories", categoryService.findAll());
	      return mav;
	   }

	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	   public ModelAndView loginPage() {
	      ModelAndView mav = new ModelAndView("login");
	      return mav;
	   }
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	   public ModelAndView registerPage(HttpServletRequest request) {
	      ModelAndView mav = new ModelAndView("register");
	      if (request.getParameter("message") != null) {
	    	  	Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
				mav.addObject("message", message.get("message"));
				mav.addObject("alert",  message.get("alert"));
		}
	      return mav;
	   }
	
	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	   public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
	      return new ModelAndView("redirect:/trang-chu");
	   }
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	   public ModelAndView accessDenied() {
	      ModelAndView mav = new ModelAndView("login");
	      return new ModelAndView("redirect:/dang-nhap?accessDenied");
	   }
}
