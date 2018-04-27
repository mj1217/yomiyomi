package com.yedam.app.classes.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.classes.ClassService;
import com.yedam.app.classes.ClassVO;

@Service("classService")
public class ClassServiceImpl implements ClassService{
	
	@Autowired
	ClassDAO dao;
	
	@Override
	public void insertClass(ClassVO vo) {
		dao.insertClass(vo);
	}
	
	@Override
	public void updateClass(ClassVO vo) {
		dao.updateClass(vo);
	}
	
	@Override
	public void deleteClass(ClassVO vo) {
		dao.deleteClass(vo);
	}

	@Override
	public List<ClassVO> getClassList(ClassVO vo) {
		return dao.getClassList(vo);
	}
	
	@Override
	public List<ClassVO> getClassList2(ClassVO vo) {
		return dao.getClassList2(vo);
	}

	@Override
	public ClassVO getClass(ClassVO vo) {
		return dao.getClass(vo);
	}

	@Override
	public int getCount(ClassVO vo) {
		return dao.getCount(vo);
	}

	@Override
	public List<ClassVO> getClassListNP(ClassVO vo) {
		return dao.getClassListNP(vo);
	}

	@Override
	public List<ClassVO> getClassAttList(ClassVO vo) {
		// TODO Auto-generated method stub
		return dao.getClassAttList(vo);
	}

}
