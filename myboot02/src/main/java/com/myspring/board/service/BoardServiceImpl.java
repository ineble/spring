package com.myspring.board.service;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.board.dao.BoardDAO;
import com.myspring.board.vo.ArticleVO;



@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService{

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List listArticles() throws Exception {
		List articleList = boardDAO.selectAllArticleList();
		return articleList;
	}

	@Override
	public int addNewArticle(Map articleMap) throws Exception {
		int articleNO = boardDAO.selectNewArticleNO();
		System.out.println("articleNO : "  + articleNO);
		articleMap.put("articleNO", articleNO);
		boardDAO.insertNewArticle(articleMap);
		//sqlSession.insert("com.myspring.board.dao.BoardDAO.insertNewArticle", articleMap);
		//return koboardDAO.insertNewArticle(articleMap);
		return articleNO;
	}

	@Override
	public ArticleVO viewArticle(int articleNO) throws Exception {
		ArticleVO articleVO = boardDAO.selectArticle(articleNO);
		return articleVO;
	}

	@Override
	public void modArticle(Map articleMap) throws Exception{
		boardDAO.updateArticle(articleMap);
		
	}

	@Override
	public void removeArticle(int articleNO) throws Exception {
		boardDAO.deleteArticle(articleNO);
		
	}

	
	
	
}
