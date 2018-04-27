package com.yedam.app.member.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.member.MemberService;
import com.yedam.app.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMyBatisDAO dao;

	@Override
	public boolean login(MemberVO vo) {
		// id 조회
		MemberVO memberVO = (MemberVO) dao.getMember_id(vo);

		// 입력 패스워드 db 패스워드 비교
		if (memberVO != null && vo.getPwd().equals(memberVO.getPwd())) {
			return true;
		}
		return false;
	}

	@Override
	public MemberVO getMember_id(MemberVO vo) {
		return dao.getMember_id(vo);
	}

	@Override
	public List<MemberVO> getMemberList(MemberVO vo) {
		return dao.getMemberList(vo);
	}

	// 수정
	@Override
	public void memberUpdate(MemberVO vo) {
		dao.memberUpdate(vo);
	}

	// 비밀번호 변경
	@Override
	public void changePwd(MemberVO vo) {
		dao.changePwd(vo);
	}

	// 학생추가
	@Override
	public void insertMember(Map<String, Object> vo) {
		dao.insertMember(vo);
	}

	@Override
	public String getRn() {
		return dao.getRn();
	}

	// 비밀번호 찾기
	@Override
	public void find_pwd(MemberVO vo) {
		dao.find_pwd(vo);
	}

	@Override
	public List<Map> getMember_idPdf(MemberVO vo) {
		return dao.getMember_idPdf(vo);
	}

	/*
	 * @Override public void adminMemberUpdate(MemberVO vo) {
	 * dao.adminMemberUpdate(vo); }
	 */

	/*
	 * @Override public MemberVO getPwd(MemberVO vo) { return dao.getPwd(vo); }
	 */

	/*
	 * @Override public List<Map<String, Object>> getMember() { return
	 * dao.getEmployeeAll(); }
	 */

}
