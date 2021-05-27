package com.project.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.ProductDTO;
import com.project.service.IProductService;
import com.project.util.MessageUtil;

@Controller(value = "productControllerOfWeb")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/san-pham/chi-tiet", method = RequestMethod.GET)
	   public ModelAndView ProductDetails(@RequestParam(value ="id" ,required = false) Long id) {
		
			ModelAndView mav = new ModelAndView("web/productDetails");
			ProductDTO model = productService.findById(id);
			mav.addObject("model", model);
			return mav;
	   }
	
	@RequestMapping(value = "/san-pham/cart", method = RequestMethod.GET)
	   public ModelAndView CartPage(@RequestParam(value ="id" ,required = false) Long id, HttpServletRequest request) {
		
			ModelAndView mav = new ModelAndView("web/cart");
			ProductDTO model = productService.findById(id);
			if (request.getParameter("message") != null) {
	    	  	Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
				mav.addObject("message", message.get("message"));
				mav.addObject("alert",  message.get("alert"));
		}
			mav.addObject("model", model);
			return mav;
	   }
}
