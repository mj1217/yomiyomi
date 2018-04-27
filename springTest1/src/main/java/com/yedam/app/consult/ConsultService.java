package com.yedam.app.consult;
import java.util.List;
import com.yedam.app.consult.ConsultVO;
import com.yedam.app.member.MemberVO;

public interface ConsultService {

	public void insertConsult(ConsultVO vo);
	public void updateConsult(ConsultVO vo);
	public void deleteConsult(ConsultVO vo);
	public ConsultVO getConsult(ConsultVO vo);
	public List<ConsultVO> getConsultAjax(ConsultVO vo);
	public List<ConsultVO> getConsultList(ConsultVO vo);
	public int getCount(ConsultVO vo);
	public List<MemberVO> getStudentList(ConsultVO vo);
	public List<ConsultVO> getConsultListSelect(String m_memberid);
	
}
