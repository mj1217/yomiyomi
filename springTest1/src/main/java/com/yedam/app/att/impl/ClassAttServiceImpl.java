package com.yedam.app.att.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.att.ClassAttService;

@Service("classAttService")
public class ClassAttServiceImpl implements ClassAttService {

	
	@Autowired
	ClassAttDAO dao;
	
	/* (non-Javadoc)
	 * @see com.yedam.app.att.impl.ClassAttService#getClassAttList()
	 */
	@Override
	public List<Map<String,Object>> getAttList(Integer cl_no){
		return dao.getAttList(cl_no);
	}
	
	@Override
	public List<Map<String,Object>> getAttSubjectList(Integer cl_no){
		return dao.getAttSubjectList(cl_no);
	}


	@Override
	public List<Map<String, Object>> getAttTimeList(String name) {
		// TODO Auto-generated method stub
		return dao.getAttTimeList(name);
	}

	@Override
	public Map<String, Object> getAttSubjectOne(String t_id) {
		// TODO Auto-generated method stub
		return dao.getAttSubjectOne(t_id);
	}

	@Override
	public Map<String, Object> getClassInfoOne(String id) {
		// TODO Auto-generated method stub
		return dao.getClassInfoOne(id);
	}

	@Override
	public Map<String, Object> getMemberId(String name) {
		// TODO Auto-generated method stub
		return dao.getMemberId(name);
	}
	
	
	
}
