package com.yedam.app.scheduler;

import java.util.List;
import java.util.Map;



public interface SchedulerService {

	public List<Map<String,Object>> getSchedulerajax(SchedulerVO vo);
	public void insertSchedulerajax(SchedulerVO vo);
	public void updateSchedulerajax(SchedulerVO vo);
	public void deleteSchedulerajax(SchedulerVO vo);
}
