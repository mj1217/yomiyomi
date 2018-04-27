package com.yedam.app.classinfo;

import java.util.List;
import java.util.Map;

public interface ClassInfoService {
	
	public List<Map<String, Object>> getClassInfo(Map<String, Object> vo);
	public void insertClassInfo(Map<String, Object> vo);
}