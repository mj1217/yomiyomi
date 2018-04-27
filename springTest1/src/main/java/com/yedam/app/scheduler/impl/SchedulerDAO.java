package com.yedam.app.scheduler.impl;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.app.scheduler.SchedulerVO;

@Repository
public class SchedulerDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession; //mybatis-context bean 등록되있음 //jdbc템플릿 대신
	
	
	
	public List<Map<String,Object>> getSchedulerajax(SchedulerVO vo){ // schedulerMapper 에 지정한 , (namespace id. 메소드 id)
		return  sqlSession.selectList("scheduler.getSchedulerajax",vo);
	}
	
	public void insertSchedulerajax(SchedulerVO vo){
		sqlSession.insert("scheduler.insertSchedulerajax",vo);
	}
	
	public void updateSchedulerajax(SchedulerVO vo){
		sqlSession.update("scheduler.updateSchedulerajax",vo);
	}
	
	public void deleteSchedulerajax(SchedulerVO vo){
		sqlSession.delete("scheduler.deleteSchedulerajax",vo);
	}

	
}
