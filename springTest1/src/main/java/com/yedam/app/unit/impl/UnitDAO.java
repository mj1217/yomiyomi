package com.yedam.app.unit.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.app.unit.ExcelVO;
import com.yedam.app.unit.UnitVO;


@Repository
public class UnitDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public void insertUnit(UnitVO vo) {
		sqlSession.insert("unit.insertUnit",vo); 
	}
	
	public void updateUnit(UnitVO vo){
		sqlSession.update("unit.updateUnit",vo);
	}

	public void deleteUnit(UnitVO vo){
		sqlSession.delete("unit.deleteUnit",vo);
	}
	
	public List<UnitVO> getUnitList(UnitVO vo){
		return sqlSession.selectList("unit.getUnitList", vo);
	}
	
	
	public void insertExcel(ExcelVO vo) {
		sqlSession.insert("unit.insertExcel",vo);
	}
	
	public List<UnitVO> getSDATE(UnitVO vo){
		return sqlSession.selectList("unit.getSDATE",vo);
	}
	
	public UnitVO getAttendDays(UnitVO vo) {
		return sqlSession.selectOne("unit.getAttendDays",vo);
	}
	
	public void caculateAttend() {
		sqlSession.update("unit.calculateAttend");
	}
	
	public  List<UnitVO> getUnit(UnitVO vo) {
		return sqlSession.selectList("unit.getUnit",vo);
	}
	
	public UnitVO getAbsence(UnitVO vo){
		return sqlSession.selectOne("unit.getAbsence",vo);
	}
	
	public List<UnitVO> getScore(UnitVO vo) {
		return sqlSession.selectList("unit.getScore",vo);
	}
	
}

