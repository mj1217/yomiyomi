package com.yedam.app.sampledata;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.unit.UnitVO;

public interface SampleService {

	List<Map<String, Object>> getSampleData(Map<String, Object> vo);
	public Map<String,Object> getCodeName(Map<String,Object> vo);
	public void updateAtt(Map<String,Object> vo);
	public void insertTimeTableAtt(Map<String,Object> vo);
	public void getSubjectTimeList(String filepath);
	public List<Map<String,Object>> checkTimeTable();
	public List<Map<String,Object>> getExcelTimeTable(String filepath);
	public Map<String,Object> convertCode(String code_name);
	public Map<String,Object> convertSubject(Map<String,Object> vo);
	public Map<String,Object> getRowNum();

	public void insertViewTimeTable(Model model, @RequestParam int sub_no,String filepath);
	public void getClassMemberList(@RequestParam int sub_no);
	
}