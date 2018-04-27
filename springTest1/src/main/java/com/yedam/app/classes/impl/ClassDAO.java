package com.yedam.app.classes.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.app.classes.ClassVO;

@Repository
public class ClassDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public void insertClass(ClassVO vo) {
		sqlSession.insert("class.insertClass", vo);
	}
	
	public void updateClass(ClassVO vo) {
		sqlSession.update("class.updateClass", vo);
	}
	
	public void deleteClass(ClassVO vo) {
		sqlSession.delete("class.deleteClass", vo);
	}
	
	public List<ClassVO> getClassList(ClassVO vo) {
		return sqlSession.selectList("class.getClassList", vo);
	}
	
	public List<ClassVO> getClassList2(ClassVO vo) {
		return sqlSession.selectList("class.getClassList2", vo);
	}
	
	public ClassVO getClass(ClassVO vo) {
		return sqlSession.selectOne("class.getClass", vo);
	}
	
	public int getCount(ClassVO vo) {
		return sqlSession.selectOne("class.getCount", vo);
	}
	public List<ClassVO> getClassListNP(ClassVO vo){
		return sqlSession.selectList("class.getClassListNP", vo);
	}
	
	public List<ClassVO> getClassAttList(ClassVO vo){
		return sqlSession.selectList("class.getClassAttList", vo);
	}
	
}
