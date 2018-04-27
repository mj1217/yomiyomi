package com.yedam.app.unit.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.unit.UnitInsertVO;
import com.yedam.app.unit.UnitService;
import com.yedam.app.unit.UnitVO;

@Service("unitService")
public class UnitServiceImpl implements UnitService{

	@Autowired
	UnitDAO dao;
	
	@Override
	public void insertUnit(UnitInsertVO uvo ) {
		UnitVO vo = new UnitVO();
	
		for(int i=0; i<uvo.getUnit().length;i++) {
			vo.setClass_no(uvo.getClass_no());
			vo.setUnit(uvo.getUnit()[i]);
			vo.setUnitdays(uvo.getUnitdays()[i]);
			vo.setEdate(uvo.getEdate()[i]);
			vo.setSdate(uvo.getSdate()[i]);
			dao.insertUnit(vo); 
			
		} 
		
	}


	public void updateUnit(UnitVO vo) {
		dao.updateUnit(vo);
	}

	
	public void deleteUnit(UnitVO vo) {
		dao.deleteUnit(vo);
	}


	public List<UnitVO> getUnitList(UnitVO vo) {
		return dao.getUnitList(vo);
	}


	@Override
	public List<UnitVO> getSDATE(UnitVO vo) {
		return dao.getSDATE(vo);
	}

	public UnitVO getAttendDays(UnitVO vo) {
		return dao.getAttendDays(vo);
	}


	public  List<UnitVO> getUnit(UnitVO vo) {
		return dao.getUnit(vo);
	}
	

	public UnitVO getAbsence(UnitVO vo){
		return dao.getAbsence(vo);
		
		
	}
	public List<UnitVO> getScore(UnitVO vo) {

		return dao.getScore(vo);
		
	}
	
}
