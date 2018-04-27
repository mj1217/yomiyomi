package com.yedam.app.timetable.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.app.timetable.TimeTableVO;

@Repository
public class TimeTableDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<TimeTableVO> getTimeTableList(TimeTableVO vo) {
		return sqlSession.selectList("timeTable.getTimeTableList", vo);
	}
	
	public List<TimeTableVO> getClassTimeTable(TimeTableVO vo) {
		return sqlSession.selectList("timeTable.getClassTimeTable", vo);
	}
	
}
