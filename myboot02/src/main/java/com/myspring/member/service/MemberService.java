package com.myspring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.member.vo.MemberVO;

public interface MemberService {

	public List listMembers() throws DataAccessException;

	public int addMember(MemberVO memberVO) throws DataAccessException;

	public int removeMember(String id) throws DataAccessException;
	

	public MemberVO modMember(String id) throws DataAccessException;

	public int updateMember(MemberVO memberVO) throws DataAccessException;

	public MemberVO login(MemberVO membervo) throws Exception;


	//public List<MemberVO> searchMember(MemberVO memberVO) throws DataAccessException;

	

}
