package com.yedam.app.subject.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.subject.SubjectService;
import com.yedam.app.subject.SubjectVO;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	SubjectDAO dao;

	@Override
	public void insertSubject(Map<String,Object> vo) {
		dao.insertSubject(vo);
	}

	@Override
	public void updateSubject(SubjectVO vo) {
		dao.updateSubject(vo);
	}

	@Override
	public void deleteSubject(SubjectVO vo) {
		dao.deleteSubject(vo);
	}

	@Override
	public List<SubjectVO> getSubjectList(SubjectVO vo) {
		return dao.getSubjectList(vo);
	}

	@Override
	public int getCount(SubjectVO vo) {
		 return dao.getCount(vo);
	}

	@Override
	public SubjectVO getSubject(SubjectVO vo) {
		return dao.getSubject(vo);
	}

	@Override
	public List<SubjectVO> getSubjectListAjax(SubjectVO vo) {
		return dao.getSubjectListAjax(vo);
	}

}
