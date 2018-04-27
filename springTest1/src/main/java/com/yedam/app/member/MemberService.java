package com.yedam.app.member;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


public interface MemberService {

	public MemberVO getMember_id(MemberVO vo);
	public List<Map> getMember_idPdf(MemberVO vo);
	//public MemberVO getPwd(MemberVO vo);
	public boolean login(MemberVO vo);
	//public boolean loginCheck(MemberVO vo, HttpSession session);
	public List<MemberVO> getMemberList(MemberVO vo);
	public void memberUpdate(MemberVO vo);
	public void changePwd(MemberVO vo);
	public void insertMember(Map<String,Object> vo);
	public String getRn();
	public void find_pwd(MemberVO vo);
	//public void adminMemberUpdate(MemberVO vo);
	//public List<Map<String,Object>> getMember();
	
}
