package com.myspring.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.board.vo.ArticleVO;
import com.myspring.common.interceptor.interceptorConfig;


@Mapper
@Repository("boardDAO")
public interface BoardDAO {
	public List selectAllArticleList() throws Exception;

	public int insertNewArticle(Map articleMap) throws DataAccessException;

	public ArticleVO selectArticle(int articleNO) throws DataAccessException;

	public void updateArticle(Map articleMap) throws DataAccessException;

	public void deleteArticle(int articleNO) throws DataAccessException;
	
	public List selectImageFileNO(int articleNO) throws DataAccessException;

	public int selectNewArticleNO() throws DataAccessException; 
	

	
}
