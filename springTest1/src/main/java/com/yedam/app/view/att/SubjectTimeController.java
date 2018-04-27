package com.yedam.app.view.att;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.app.subject_timetable.SubjectTimeService;
import com.yedam.app.subject_timetable.SubjectTimeVO;

@Controller
public class SubjectTimeController {

	
	@Autowired
	SubjectTimeService subjectTimeService;
	
	@RequestMapping("/getSubjectTimeList")
	public String getSubjectTimeList(Model model,SubjectTimeVO vo,
								Locale locale) {
		
		System.out.println(subjectTimeService.getSubjectTimeList(vo));
		List<SubjectTimeVO> list = subjectTimeService.getSubjectTimeList(vo);
		
		model.addAttribute("subjectTime",list);
		
		return "subjectTime/getSubjectTimeList";
	}
	
}
