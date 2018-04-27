package com.yedam.app.sampledata.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public class SampleBybatisDAO {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	public List<Map<String,Object>> getSampleData(Map<String,Object> vo){
		
		return sqlSession.selectList("dataview.getDataList",vo);
	}
	
	public Map<String,Object> getCodeName(Map<String,Object> vo){
		
		return sqlSession.selectOne("dataview.getCodeName",vo);
	}
	
	
	public void updateAtt(Map<String,Object> vo){
		
		sqlSession.update("dataview.updateAtt",vo);
		System.out.println("1건 업데이트 완료!");
	}
	
	public void insertTimeTableAtt(Map<String,Object> vo) {
		sqlSession.insert("dataview.insertTimeTable",vo);
	}
	
	public List<Map<String,Object>> checkTimeTable(){
		return sqlSession.selectList("dataview.checkTimeTable");
	}
	
	public List<Map<String,Object>> checkAttTable(){
		return sqlSession.selectList("dataview.checkAttTable");
	}
	
	
	public Map<String,Object> convertCode(String code_name){
		return sqlSession.selectOne("dataview.convertCode",code_name);
	}
	
	public Map<String,Object> convertSubject(Map<String,Object> vo){
		return sqlSession.selectOne("dataview.convertSubject",vo);
	}
	
	public Map<String,Object> getRowNum(){
		return sqlSession.selectOne("dataview.getRowNum");
	}
	
	public Map<String,Object> getRowNumAtt(){
		return sqlSession.selectOne("dataview.getRowNumAtt");
	}
	
	public List<Map<String,Object>> getClassMemberList(int sub_no){
		return sqlSession.selectList("dataview.getClassMemberList",sub_no);
	}
	
	public List<Map<String,Object>> getTimetableList(int sub_no){
		return sqlSession.selectList("dataview.getTimetableList",sub_no);
	}
	
	public void insertAttendance(Map<String,Object> vo) {
		
		sqlSession.insert("dataview.insertAttendance",vo);
	}
}
