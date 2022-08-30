package com.myspring.board.service;

import java.util.List;
import java.util.Map;

import com.myspring.board.vo.ArticleVO;


public interface BoardService {
	public int addNewArticle(Map articleMap) throws Exception;

	public ArticleVO viewArticle(int articleNO) throws Exception;

	public void modArticle(Map articleMap) throws Exception;

	public void removeArticle(int articleNO) throws Exception;

	public List listArticles() throws Exception;




	

}
