package com.yedam.app.consult.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.consult.ConsultService;
import com.yedam.app.consult.ConsultVO;
import com.yedam.app.member.MemberVO;

@Service("consultService")
public class ConsultServiceImpl implements ConsultService{

	@Autowired
	ConsultDAO dao;
	
	public void insertConsult(ConsultVO vo) {
		dao.insertConsult(vo);
	}

	
	public void updateConsult(ConsultVO vo) {
		dao.updateConsult(vo);
	}


	public void deleteConsult(ConsultVO vo) {
		dao.deleteConsult(vo);
	}

	
	public ConsultVO getConsult(ConsultVO vo) {
		return dao.getConsult(vo);
	}
	
	public List<ConsultVO> getConsultAjax(ConsultVO vo) {
		return dao.getConsultAjax(vo);
	}

	public List<ConsultVO> getConsultList(ConsultVO vo) {
		return dao.getConsultList(vo);
	}


	public int getCount(ConsultVO vo) {
		return dao.getCount(vo);
	}


	@Override
	public List<MemberVO> getStudentList(ConsultVO vo) {
		return dao.getStudentList(vo);
		
	}


	@Override
	public List<ConsultVO> getConsultListSelect(String m_memberid) {
		// TODO Auto-generated method stub
		return dao.getConsultListSelect(m_memberid);
	}

	
}
