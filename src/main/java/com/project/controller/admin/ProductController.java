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

import com.project.dto.ProductDTO;
import com.project.service.IProductService;
import com.project.util.MessageUtil;

@Controller(value = "productControllerOfAdmin")
public class ProductController {

	@Autowired
	private IProductService newService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	
	@RequestMapping(value = "/quan-tri/san-pham/danh-sach", method = RequestMethod.GET)
	   public ModelAndView showList(@RequestParam("page") int page, 
			   						@RequestParam("limit") int limit, HttpServletRequest request) {
		ProductDTO model = new ProductDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/product/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(newService.findAll(pageable));
		model.setTotalItem(newService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert",  message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	   }

//	@RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
//	   public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
//	      ModelAndView mav = new ModelAndView("admin/new/edit");
//	      NewDTO model = new NewDTO();
//	      if(id != null) {
//	    	  model = newService.findById(id);  
//	      }
//	      if (request.getParameter("message") != null) {
//	    	  	Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
//				mav.addObject("message", message.get("message"));
//				mav.addObject("alert",  message.get("alert"));
//		}
//	      mav.addObject("categories", categoryService.findAll());
//	      mav.addObject("model", model);
//	      return mav;
//	   }
	
//	@RequestMapping(value = "/quan-tri/bai-viet/chinh-sua/{id}", method = RequestMethod.GET)
//	   public ModelAndView updateNew(@PathVariable("id") long id) {
//	      ModelAndView mav = new ModelAndView("admin/new/edit");
//	      return mav;
//	   }
}
