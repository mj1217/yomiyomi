package com.yedam.app.classinfo.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.app.classes.ClassVO;

@Repository
public class ClassInfoDAO {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Map<String, Object>> getClassInfo(Map<String, Object> vo) {
		return sqlSession.selectList("classInfo.getClassInfo", vo);
	}
	
	public void insertClassInfo(Map<String,Object> vo) {
		sqlSession.insert("classInfo.insertClassInfo",vo);
	}
	
}
