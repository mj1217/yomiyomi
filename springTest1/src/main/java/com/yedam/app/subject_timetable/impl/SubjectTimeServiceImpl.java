package com.yedam.app.subject_timetable.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.subject_timetable.SubjectTimeService;
import com.yedam.app.subject_timetable.SubjectTimeVO;

@Service("subjectTimeService")
public class SubjectTimeServiceImpl implements SubjectTimeService{

	
	
	@Autowired
	SubjectTimeMybatisDAO dao;

	@Override
	public List<SubjectTimeVO> getSubjectTimeList(SubjectTimeVO vo) {
		// TODO Auto-generated method stub
		return dao.getSubjectTimeList(vo);
	}
	
	
	
}
