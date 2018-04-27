package com.yedam.app.view.subject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yedam.app.classes.ClassService;
import com.yedam.app.classes.ClassVO;
import com.yedam.app.common.Paging;
import com.yedam.app.member.MemberService;
import com.yedam.app.member.MemberVO;
import com.yedam.app.subject.SubjectService;
import com.yedam.app.subject.SubjectVO;

@Controller
public class SubjectController {

	@Autowired
	SubjectService subjectService;

	@Autowired
	ClassService classService;

	@Autowired
	MemberService memberService;

	// 목록
	@RequestMapping("/getSubjectList")
	public String getSubjectList(Model model, SubjectVO vo, ClassVO cvo, Paging paging, HttpSession session) {
		// 전체 레코드 건수
		paging.setPageUnit(10);
		paging.setTotalRecord(subjectService.getCount(vo));

		// vo의 first, last setting
		vo.setFirst(paging.getFirst());
		vo.setLast(paging.getLast());

		// 결과저장
		model.addAttribute("classList", classService.getClassListNP(cvo));
		model.addAttribute("SubjectList", subjectService.getSubjectList(vo));
		model.addAttribute("paging", paging);

		return "subject/getSubjectList";
	}

	// 검색 처리
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("과정명", "class_name");
		conditionMap.put("과목명", "subject");
		conditionMap.put("사용여부", "status_yn");
		return conditionMap;
	}

	// 등록폼
	@RequestMapping("/insertSubjectForm")
	public String insertSubjectForm(Model model, ClassVO vo) {
		model.addAttribute("ClassList", classService.getClassList2(vo));
		return "subject/insertSubject";
	}

	// 등록처리
	@RequestMapping(value = "insertSubject", method = RequestMethod.POST)
	public String insertSubject(@RequestParam String[] subject,@RequestParam String[] totalTime, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();

		///String[] id = new String[subject.length];
		for (int i = 0; i < subject.length; i++) {
			//id[i] = subject[i];

			map.put("subject", subject[i]);
			map.put("totalTime", totalTime[i]);
			//map.put("status_yn", request.getParameter("status_yn"));
			map.put("cl_no", request.getParameter("cl_no"));

			subjectService.insertSubject(map);
		}
		return "redirect:/getSubjectList";
	}

	// 상세보기
	@RequestMapping("/getSubject/{su_no}")
	public ModelAndView getSubject(@PathVariable Integer su_no, HttpSession session) {
		SubjectVO vo = new SubjectVO();
		vo.setSu_no(su_no);

		ModelAndView mv = new ModelAndView();
		mv.addObject("su", subjectService.getSubject(vo));
		mv.setViewName("subject/getSubject");
		return mv;
	}

	// 수정폼
	@RequestMapping("/updateSubjectForm")
	public String updateSubjectForm(Model model, SubjectVO vo, ClassVO vo2) {
		model.addAttribute("su", subjectService.getSubject(vo));
		model.addAttribute("ClassList", classService.getClassList2(vo2));
		return "subject/updateSubject";
	}

	// 수정처리
	@RequestMapping("/updateSubject")
	public String updateSubject(SubjectVO vo) {
		subjectService.updateSubject(vo);
		return "redirect:/getSubjectList";
	}

	// 삭제
	@RequestMapping("/deleteSubject")
	public String deleteSubject(SubjectVO vo) {
		subjectService.deleteSubject(vo);
		return "redirect:/getSubjectList";
	}
}
