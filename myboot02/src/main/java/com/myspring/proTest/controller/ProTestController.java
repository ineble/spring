package com.myspring.proTest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;



public interface ProTestController {
	
	public ModelAndView proTest(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
