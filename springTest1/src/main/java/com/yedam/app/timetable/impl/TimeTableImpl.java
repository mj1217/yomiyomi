package com.yedam.app.timetable.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.timetable.TimeTableService;
import com.yedam.app.timetable.TimeTableVO;

@Service("TimeTableService")
public class TimeTableImpl implements TimeTableService {

	@Autowired
	TimeTableDAO dao;
	
	@Override
	public List<TimeTableVO> getTimeTableList(TimeTableVO vo) {
		return dao.getTimeTableList(vo);
	}

	@Override
	public List<TimeTableVO> getClassTimeTable(TimeTableVO vo) {
		return dao.getClassTimeTable(vo);
	}

}
