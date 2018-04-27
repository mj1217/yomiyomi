package com.yedam.app.memberAdd;

import java.util.List;
import java.util.Map;

public interface MemberAddService {

	//학생추가
	public void insertMember(Map<String, Object> vo);

	public String getRn();
	public List<Map<String,Object>> getMemberAddList();
	public List<Map<String,Object>> getMembertAjax(String m_detail);
	
}