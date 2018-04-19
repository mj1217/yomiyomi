package com.yedam.app.emp.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.EmpService;
import com.yedam.app.emp.EmployeeVO;

@Service("empService")
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpMybatisDAO dao;
	
	
	public List<EmployeeVO> getEmpList(EmployeeVO vo){

		return dao.getEmpList(vo);
		 
	}

	@Override
	public int getCount(EmployeeVO vo) {
		return dao.getCount(vo);
		
	}

	@Override
	public  List<Map<String, Object>> getDeptEmpStatistic() {
		
		return dao.getDeptEmpStatistic();
	}

	public List<Map<String, Object>> getEmployeeAll(){
		return dao.getEmployeeAll();
	}

}
