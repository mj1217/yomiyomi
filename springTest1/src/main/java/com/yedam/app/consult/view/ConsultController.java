package com.yedam.app.consult.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.classes.ClassService;
import com.yedam.app.classes.ClassVO;
import com.yedam.app.common.Paging;
import com.yedam.app.consult.ConsultService;
import com.yedam.app.consult.ConsultVO;
import com.yedam.app.member.MemberVO;
import com.yedam.app.member.MemberService;

@Controller
public class ConsultController {

	@Autowired 
	ConsultService consultService;
	
	@Autowired 
	MemberService memberService;
	
	@Autowired 
	ClassService classService;
	
	
	//목록보기
	@RequestMapping("/getConsultList")
	public String getConsultList(Model model, ConsultVO vo, ClassVO cvo, MemberVO mvo,Paging paging) {
	
		//전체 레코드 건수
		paging.setTotalRecord(consultService.getCount(vo));
		//vo의 first, last 셋팅
		vo.setFirst(paging.getFirst());
		vo.setLast(paging.getLast()); 
		//결과저장
		
		model.addAttribute("memberList",memberService.getMemberList(mvo));
		model.addAttribute("classList",classService.getClassListNP(cvo));
		model.addAttribute("consultList",consultService.getConsultList(vo));
		model.addAttribute("paging",paging);	
		return "consult/getConsultList";
		
	}
	
	
	@RequestMapping("/getConsultListSelect")
	
	public String getConsultListSelect(Model model, ConsultVO vo, ClassVO cvo, MemberVO mvo,Paging paging,String m_memberid) {
		
		model.addAttribute("memberList",memberService.getMemberList(mvo));
		model.addAttribute("classList",classService.getClassListNP(cvo));
		model.addAttribute("consultList",consultService.getConsultListSelect(m_memberid));
		model.addAttribute("paging",paging);	
		return "consult/getConsultList";
		
	}
	
	
	
	//상세보기
	@RequestMapping("/getConsult")
	public String getconsult(Model model, Integer c_no ) {
		ConsultVO vo = new ConsultVO();
		vo.setC_no(c_no);
		model.addAttribute("consult", consultService.getConsult(vo)); 
		return "consult/getConsult";
	}
	
	//수정폼
	@RequestMapping("/updateConsultForm")
	public String updateConsultForm(Model model, ConsultVO vo, ClassVO cvo) {
		model.addAttribute("classList",classService.getClassListNP(cvo));
		model.addAttribute("consult", consultService.getConsult(vo));
		return "consult/updateConsult";
	}
	
	//수정처리
	@RequestMapping("/updateConsult")
	public String updateConsult( ConsultVO vo) { 
		int c_no = vo.getC_no();
		consultService.updateConsult(vo);
		return "redirect:/getConsult?c_no="+c_no;
		}
	
	//삭제처리
	@RequestMapping("/deleteConsult")
	public String deleteConsult( ConsultVO vo) {
		consultService.deleteConsult(vo);
		return "redirect:/getConsultList";
		}
	
	//등록처리
	@RequestMapping("/insertConsult")
	public String insertConsult(ConsultVO vo) {
		consultService.insertConsult(vo);
		return "redirect:/getConsultList";
	}
	
	//등록폼으로
	@RequestMapping("/insertConsultForm")
	public String insertConsultForm(Model model, ConsultVO vo, ClassVO cvo, MemberVO mvo) {
		model.addAttribute("memberList",memberService.getMemberList(mvo));
		model.addAttribute("classList",classService.getClassListNP(cvo));
		return "consult/insertConsultForm";
	}
	
	//과정에 해당하는 학생 불러오기
	@RequestMapping("/getStudentList")
	@ResponseBody
	public List<MemberVO> getStudentList( ConsultVO vo) {
		return consultService.getStudentList(vo);
	}

	//학생 선택하면 해당하는 상담일지 가져오기
	@RequestMapping("/getConsultAjax")
	@ResponseBody
	public List<ConsultVO> getconsult(String s_detail ) {
		ConsultVO vo = new ConsultVO();
		vo.setS_detail(s_detail);
		return consultService.getConsultAjax(vo);
	}
	
}
