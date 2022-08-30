package com.myspring.proTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.proTest.dao.ProTestDAO;


@Service("proTestService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProTestServiceImpl implements ProTestService{

	@Autowired
	private ProTestDAO proTestDAO;

	@Override
	public List listMembers() throws DataAccessException {
		List memberList = null;
		memberList = proTestDAO.selectAllMemberList();
		
		return memberList;
	}

		
	
}
