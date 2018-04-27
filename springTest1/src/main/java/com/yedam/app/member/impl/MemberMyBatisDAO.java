package com.yedam.app.member.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.app.member.MemberVO;



@Repository
public class MemberMyBatisDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<MemberVO> getMemberList(MemberVO vo){
		System.out.println("mybatis getMemberList");
		return sqlSession.selectList("member.getMemberList",vo);
	}
	
	public int getCount(MemberVO vo) {
		return sqlSession.selectOne("member.getCount", vo);
	}
	
	public MemberVO getMember_id(MemberVO vo) {
		return sqlSession.selectOne("member.getMember_id",vo);
	}
	
	public List<Map> getMember_idPdf(MemberVO vo) {
		return sqlSession.selectList("member.getMember_idPdf",vo);
	}
	
	/*public void getPwd(MemberVO vo) {
		sqlSession.update("member.getPwd", vo);
	}*/

	public MemberVO getName(MemberVO vo) {
		return sqlSession.selectOne("member.getName", vo);
	}
	
	public void memberUpdate(MemberVO vo) {
		sqlSession.update("member.memberUpdate", vo);
	}
	
	public void changePwd(MemberVO vo) {
		sqlSession.update("member.changePwd", vo);
	}
	
	
	public void insertMember(Map<String,Object> vo) {
		sqlSession.insert("member.insertMember",vo);
	}
	
	public String getRn() {
		return sqlSession.selectOne("member.getRn");
	}
	
	public void find_pwd(MemberVO vo) {
		sqlSession.update("member.find_pwd", vo);
	}
	
	public void adminMemberUpdate(MemberVO vo) {
		sqlSession.update("member.adminMemberUpdate", vo);
	}
	
	/*public List<Map<String,Object>> getMember(){
		System.out.println("mybatis getMember");
		return sqlSession.selectList("emp.getMember");
	}*/
}
