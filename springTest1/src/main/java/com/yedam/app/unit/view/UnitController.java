package com.yedam.app.unit.view;


import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yedam.app.att.ClassAttService;
import com.yedam.app.classes.ClassService;
import com.yedam.app.classes.ClassVO;
import com.yedam.app.member.MemberVO;
import com.yedam.app.sampledata.SampleService;
import com.yedam.app.unit.UnitInsertVO;
import com.yedam.app.unit.UnitService;
import com.yedam.app.unit.UnitVO;
import com.yedam.app.unit.impl.ExcelServiceImpl;

@Controller
public class UnitController {

	@Autowired
	ExcelServiceImpl excelService;
	
	@Autowired
	ClassService classService;

	@Autowired
	UnitService unitService;
	
	@Autowired
	SampleService sampleService;
	
	@Autowired
	ClassAttService classAttService;
	
	@Value("${file.uploadfolder}")
	String uploadfolder;
	
	@RequestMapping("/insertAttendanceForm") //등록 폼으로
	public String insertAttendanceForm(Model model, ClassVO cvo) {
		model.addAttribute("classList",classService.getClassListNP(cvo)); 
		return "attendance/insertAttendance";
	}
	
	@RequestMapping("/insertUnit") //등록처리
	public String insertUnit(UnitInsertVO uvo){
		unitService.insertUnit(uvo);
		return "attendance/insertAttendance";
	}
	
	@RequestMapping("/getUnitList")
	public String getUnitList(Model model, UnitVO vo, ClassVO cvo) {


		model.addAttribute("classList",classService.getClassListNP(cvo));
	
		if(vo.getClass_no()!=null && !vo.getClass_no().equals("")){
			cvo.setCl_no(vo.getClass_no());
			model.addAttribute("SDATE",unitService.getSDATE(vo));
			model.addAttribute("unitList",unitService.getUnitList(vo));
			model.addAttribute("attendDays",unitService.getAttendDays(vo));
			model.addAttribute("absence",unitService.getAbsence(vo));
			model.addAttribute("scores",unitService.getScore(vo));
			model.addAttribute("classs",classService.getClass(cvo));
		
		}
		return "attendance/viewAttendance";
	}
	

	
	@RequestMapping("/insertExcel") //엑셀 등록 처리
	public String insertExcel(Model model, UnitVO vo,  HttpServletRequest request, HttpServletResponse response)  throws IOException{
		// 첨부파일이 있는지 확인
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("attach_file"); 

		if (multipartFile != null && multipartFile.getSize() > 0) {
			// 파일을 업로드 위치에 저장
			multipartFile.transferTo(new File(uploadfolder, multipartFile.getOriginalFilename()));
			vo.setExcelFile(multipartFile.getOriginalFilename());
			excelService.getSampleList(uploadfolder+"/"+multipartFile.getOriginalFilename());
			sampleService.getSubjectTimeList(uploadfolder+"/"+multipartFile.getOriginalFilename());
		}
	
		return "forward:/getUnitList";
	}
	
	@RequestMapping("/getUnit")
	public String getUnit(Model model, UnitVO vo,HttpSession session)
	{	
		MemberVO mvo = new MemberVO();
		mvo = (MemberVO) session.getAttribute("memberVO");
		vo.setStudent_name(mvo.getName());
		System.out.println(vo);
		model.addAttribute("unit2",unitService.getUnit(vo));
		
		Map<String,Object> cl = classAttService.getClassInfoOne((String)classAttService.getMemberId(((MemberVO)session.getAttribute("memberVO")).getName()).get("member_id"));
		int cl_no = ((BigDecimal)cl.get("cl_no")).intValue();
	
		ClassVO cvo = new ClassVO();
	
		vo.setClass_no(cl_no);
		cvo.setCl_no(cl_no);
		model.addAttribute("score",unitService.getScore(vo));
		model.addAttribute("SDATE",unitService.getSDATE(vo));	
		model.addAttribute("unitList",unitService.getUnitList(vo));
		model.addAttribute("attendDays",unitService.getAttendDays(vo));
		model.addAttribute("absence",unitService.getAbsence(vo));
		model.addAttribute("classs",classService.getClass(cvo));
		return "attendance/myAttendance";
	}

}
