package com.myspring.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;



public interface BoardController {
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest ,HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView viewArticleAndView (@RequestParam("articleNO") int articleNO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ResponseEntity removeArticle(@RequestParam("articeNO") int articleNO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
