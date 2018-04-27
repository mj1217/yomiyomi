package com.yedam.app.view.timetable;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yedam.app.classes.ClassService;
import com.yedam.app.classinfo.ClassInfoService;
import com.yedam.app.member.MemberVO;
import com.yedam.app.sampledata.SampleService;
import com.yedam.app.timetable.TimeTableService;
import com.yedam.app.timetable.TimeTableVO;
import com.yedam.app.unit.UnitVO;

@Controller
public class TimeTableController {

	@Autowired
	TimeTableService timeTableService;

	@Autowired
	ClassInfoService classInfoService;
	
	@Autowired
	ClassService classService;
	
	@Autowired
	SampleService sampleService;
	
	@Value("${file.uploadfolder}")
	String uploadfolder;
	

	@RequestMapping("/getTimeTableList")
	public String myTimeTable(Model model, TimeTableVO tvo, HttpSession session) {
		// 1. 그 학생의 과정정보
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_id", ((MemberVO)session.getAttribute("memberVO")).getMember_id());
		
		List<Map<String, Object>> list = classInfoService.getClassInfo(map);
		model.addAttribute("courseType", list );
		
		// 2. 해당 과정의 시간표
		tvo.setCl_no(((BigDecimal)list.get(0).get("CL_NO")).intValue());
		model.addAttribute("timeTable", timeTableService.getTimeTableList(tvo));

		return "member/getTimeTableList";
	}
	
	// 과정별 시간표 보기
	@RequestMapping("/getClassTimeTable")
	public String getClassTimeTable(Model model, TimeTableVO tvo, HttpSession session) {
		
		model.addAttribute("timeTable", timeTableService.getClassTimeTable(tvo));
		return "class/getClassTimeTable";
	}
	
	
	//재용이가 짠거
	//insert 폼
	@RequestMapping("/insertTimeTableForm")
	public String insertViewTimeTableForm(Model model) {
		//List<ClassVO> list = ;
		//System.out.println(((MemberVO)session.getAttribute("memberVO")).getName());
		model.addAttribute("classList", classService.getClassList2(null));
		return "timetable/timetableinsertview";
	}
	//insert 처리
	@RequestMapping("/insertTimeTableView")
	public String insertViewTimeTable(Model model,UnitVO vo, @RequestParam int sub_no, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//엑셀 추가부분 
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("attach_file"); 
		
		
		if (multipartFile != null && multipartFile.getSize() > 0) {
			// 파일을 업로드 위치에 저장
			multipartFile.transferTo(new File(uploadfolder, multipartFile.getOriginalFilename()));
			vo.setExcelFile(multipartFile.getOriginalFilename());
			//excelService.getSampleList(uploadfolder+"/"+multipartFile.getOriginalFilename());
			//sampleService.getSubjectTimeList(uploadfolder+"/"+multipartFile.getOriginalFilename());
		}
		
		
		
		//끝
		
		sampleService.insertViewTimeTable(model,sub_no,uploadfolder+"/"+multipartFile.getOriginalFilename());
		sampleService.getClassMemberList(sub_no);
		model.addAttribute("classList", classService.getClassList2(null));
		
		return "timetable/timetableinsertview";
	}
	
	
	
}
