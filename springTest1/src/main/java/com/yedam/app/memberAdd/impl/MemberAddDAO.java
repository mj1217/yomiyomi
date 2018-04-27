package com.yedam.app.memberAdd.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberAddDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	public void insertMember(Map<String,Object> vo) {
		sqlSession.insert("memberAdd.insertMember",vo);
	}
	
	public String getRn() {
		return sqlSession.selectOne("memberAdd.getRn");
	}
	
	public List<Map<String,Object>> getMemberAddList(){
		return sqlSession.selectList("memberAdd.getMemberAddList");
	}
	
	public List<Map<String,Object>> getMemberAjax(String m_detail){
		return sqlSession.selectList("memberAdd.getMemberAjax",m_detail);
	}
}
