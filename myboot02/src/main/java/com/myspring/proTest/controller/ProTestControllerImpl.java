package com.myspring.proTest.controller;


import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.board.service.BoardService;
import com.myspring.board.vo.ArticleVO;
import com.myspring.member.vo.MemberVO;
import com.myspring.proTest.service.ProTestService;
import com.myspring.proTest.vo.TestVO;


@Controller("ProTestController")
public class ProTestControllerImpl implements ProTestController {
	@Autowired
	private ProTestService protestService;
	@Autowired
	private TestVO testVO;

	

	@Override
	@RequestMapping(value = "/ProTest/test9.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView proTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		System.out.println(viewName);
		List TestList = protestService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("TestList", TestList);
		return mav;
	}

}
