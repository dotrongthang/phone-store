package com.project.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	   public ModelAndView homePage() {
	      ModelAndView mav = new ModelAndView("web/home");
	      return mav;
	   }

	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	   public ModelAndView loginPage() {
	      ModelAndView mav = new ModelAndView("login");
	      return mav;
	   }
	
//	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
//	   public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (auth != null) {
//			new SecurityContextLogoutHandler().logout(request, response, auth);
//		}
//	      return new ModelAndView("redirect:/trang-chu");
//	   }
//	
//	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
//	   public ModelAndView accessDenied() {
//	      ModelAndView mav = new ModelAndView("login");
//	      return new ModelAndView("redirect:/dang-nhap?accessDenied");
//	   }
}
