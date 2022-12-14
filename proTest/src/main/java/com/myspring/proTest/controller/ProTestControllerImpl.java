package com.myspring.proTest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.proTest.service.ProTestService;
import com.myspring.proTest.vo.TestVO;

@Controller("testController")
public class ProTestControllerImpl implements ProTestController {
	@Autowired
	private ProTestService protestService;
	@Autowired
	private TestVO testVO;

	@RequestMapping(value =  "proTest/testform.do" , method = RequestMethod.GET)
	private ModelAndView main(HttpServletRequest request, HttpServletResponse response) { 
		 ModelAndView mav = new ModelAndView("proTest/testform"); 
		 return mav; 
		
	}

	@Override
	@RequestMapping(value = "protest/test9.do" , method = RequestMethod.POST)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String viewName = "proTest/listtest";
		System.out.println(viewName);
		List TestList = protestService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("TestList", TestList);
		return mav;
	}

}
