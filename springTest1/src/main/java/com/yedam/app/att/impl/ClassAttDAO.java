package com.yedam.app.att.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClassAttDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Map<String,Object>> getAttList(Integer cl_no){
		
		return sqlSession.selectList("classAtt.getAttList",cl_no);
		
	}
	
	public List<Map<String,Object>> getAttSubjectList(Integer cl_no){
		
		return sqlSession.selectList("classAtt.getAttSubjectList",cl_no);
		
	}
	public List<Map<String,Object>> getAttTimeList(String name){
		return sqlSession.selectList("classAtt.getAttTimeList",name);
	}
	
	public Map<String,Object> getAttSubjectOne(String t_id){
		return sqlSession.selectOne("classAtt.getAttSubjectOne",t_id);
	}
	
	public Map<String,Object> getClassInfoOne(String id){
		return sqlSession.selectOne("classAtt.getClassInfoOne",id);
	}
	
	public Map<String,Object> getMemberId(String name){
		return sqlSession.selectOne("classAtt.getMemberId",name);
	}
}
