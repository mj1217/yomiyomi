package com.yedam.app.view.memberAdd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.classes.ClassService;
import com.yedam.app.classes.ClassVO;
import com.yedam.app.classinfo.ClassInfoService;
import com.yedam.app.code.impl.CodeDAO;
import com.yedam.app.consult.ConsultVO;
import com.yedam.app.memberAdd.MemberAddService;

@Controller
public class MemberAddController {

	
	@Autowired
	MemberAddService memberAddService;
	
	@Autowired
	ClassService classService;
	
	@Autowired
	ClassInfoService classInfoService;
	
	@Autowired
	CodeDAO dao;
	
	//학생 등록 폼
		@RequestMapping("/insertMemberForm")
		public String insertMemberForm(Model model, ClassVO vo, Map<String,Object> vo2){
			model.addAttribute("classList", classService.getClassList2(vo));
			model.addAttribute("CodeList", dao.getCodeList(vo2));
			return "member/insertMember";
	}	
		
		@RequestMapping("/viewMember")
		public String viewMember(Model model,ClassVO vo) {
			model.addAttribute("classList", classService.getClassList2(vo));
			model.addAttribute("memberAddList", memberAddService.getMemberAddList());
			return "member/viewMember";
		}
		
		@RequestMapping("/getMemberAjax")
		@ResponseBody
		public List<Map<String,Object>> getMemberAddList(String m_detail) {
			return memberAddService.getMembertAjax(m_detail);
		}
		
		@RequestMapping("/getMemberAjaxAll")
		@ResponseBody
		public List<Map<String,Object>> getMemberAddListAll() {
			return memberAddService.getMemberAddList();
		}
		
		
		
		//학생등록 처리
		@RequestMapping(value="/memberTestView", method=RequestMethod.POST)
		public String memberTestView(@RequestParam String[] name,@RequestParam String[] social_number,HttpServletRequest request){
			
			/*System.out.println(request.getParameter("subject"));
			System.out.println(request.getParameter("subjectType"));
			
			for(int i=0;i<name.length;i++) {
				System.out.println(name[i]);
				System.out.println(social_number[i]);
			}*/
			//List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			Map<String,Object> map = new HashMap<String,Object>();
			//Map<String,Object> infomap = new HashMap<String,Object>();
			
			String[] id= new String[social_number.length];
			for(int i=0;i<social_number.length;i++) {
				id[i]=social_number[i];
				id[i]+="-"+memberAddService.getRn();
				map.put("id", id[i]);
				map.put("name", name[i]);
				map.put("social_number", social_number[i]);
				map.put("cl_no", request.getParameter("subject"));
				map.put("course_type_cd", request.getParameter("subjectType"));
				
				memberAddService.insertMember(map);
				classInfoService.insertClassInfo(map);
			}
			
			//
			
			return "redirect:/insertMemberForm";
		}
}
