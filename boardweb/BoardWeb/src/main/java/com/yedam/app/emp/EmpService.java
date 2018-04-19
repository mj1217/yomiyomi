package com.yedam.app.emp;

import java.util.List;
import java.util.Map;

import com.yedam.app.board.BoardVO;



public interface EmpService {
	
	public List<EmployeeVO> getEmpList(EmployeeVO vo);
	public int getCount(EmployeeVO vo);
	public List<Map<String, Object>> getDeptEmpStatistic();
	public List<Map<String, Object>> getEmployeeAll();

}
