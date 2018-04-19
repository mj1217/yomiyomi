package com.yedam.app.emp.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.app.emp.EmpService;
import com.yedam.app.emp.EmployeeVO;

@Repository
public class EmpMybatisDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	

	public List<EmployeeVO> getEmpList(EmployeeVO vo) {
		return sqlSession.selectList("emp.getEmpList",vo);
	}
	
	public int getCount(EmployeeVO vo) {
		return sqlSession.selectOne("emp.getCount", vo);
	}
	
	public List<Map<String, Object>> getDeptEmpStatistic() {
		return sqlSession.selectList("emp.getDeptEmpStatistic");
	}
	
	public List<Map<String, Object>> getEmployeeAll() {
		return sqlSession.selectList("emp.getEmployeeAll");
	}
	
	
}
