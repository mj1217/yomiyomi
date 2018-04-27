package com.yedam.app.att;

import java.util.List;
import java.util.Map;

public interface ClassAttService {

	public List<Map<String, Object>> getAttList(Integer cl_no);
	public List<Map<String,Object>> getAttSubjectList(Integer cl_no);
	public List<Map<String,Object>> getAttTimeList(String name);
	public Map<String,Object> getAttSubjectOne(String t_id);
	public Map<String,Object> getClassInfoOne(String id);
	public Map<String,Object> getMemberId(String name);
}