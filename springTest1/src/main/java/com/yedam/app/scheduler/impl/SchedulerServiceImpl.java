package com.yedam.app.scheduler.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.scheduler.SchedulerService;
import com.yedam.app.scheduler.SchedulerVO;




@Service("SchedulerService")
public class SchedulerServiceImpl implements SchedulerService{
	
	@Autowired
	SchedulerDAO dao;

	
	public List<Map<String,Object>> getSchedulerajax(SchedulerVO vo) {
		return dao.getSchedulerajax(vo);
	}
	
	public void insertSchedulerajax(SchedulerVO vo) {
		dao.insertSchedulerajax(vo);
	}
	
	public void updateSchedulerajax(SchedulerVO vo) {
		dao.updateSchedulerajax(vo);
	}
	
	public void deleteSchedulerajax(SchedulerVO vo) {
		dao.deleteSchedulerajax(vo);
	}
	
}
