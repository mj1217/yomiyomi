package com.yedam.app.code.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CodeDAO {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	public List<Map<String,Object>> getCodeList(Map<String,Object> vo){
		return sqlSession.selectList("code.getCodeList",vo);
	}
}
