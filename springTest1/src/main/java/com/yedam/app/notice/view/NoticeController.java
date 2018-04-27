package com.yedam.app.notice.view;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yedam.app.common.Paging;
import com.yedam.app.member.MemberService;
import com.yedam.app.notice.NoticeService;
import com.yedam.app.notice.NoticeVO;

@Controller
public class NoticeController {

	@Autowired
	NoticeService noticeService;
	
	@Autowired
	MemberService memberService;
	
	@Value("${file.uploadfolder}")
	String uploadfolder;
	//검색 처리
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String,String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "title");
		conditionMap.put("내용", "content");
		return conditionMap;
	}
	
	// 목록,페이징 처리
	@RequestMapping("/getNoticeList")
	public String getNoticeList(Model model, NoticeVO vo, Paging paging) {
		// 전체 레코드 건수
		paging.setPageUnit(10);
		paging.setTotalRecord(noticeService.getCount(vo));
		// vo에 first와 last 셋팅
		vo.setFirst(paging.getFirst());
		vo.setLast(paging.getLast());
		// 저장
		model.addAttribute("noticeList", noticeService.getNoticeList(vo));
		model.addAttribute("paging", paging);
		return "notice/getNoticeList";
	}
	

	// 상세 보기
	@RequestMapping("/getNotice")
	public String getNotice(Model model, NoticeVO vo) {
		model.addAttribute("notice", noticeService.getNotice(vo,true));
		return "notice/getNotice";
	}
	

	// 등록 폼으로 가는 컨트롤러
	@RequestMapping(value = "/insertNotice", method = RequestMethod.GET)
	public String insertNoticeForm() {
		return "notice/insertNotice";
	}

	// 등록처리
	@RequestMapping(value = "/insertNotice", method = RequestMethod.POST)
	public String insertNotice(NoticeVO vo,HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
		// 첨부파일이 있는지 확인
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("notice_file");

		if (multipartFile != null && multipartFile.getSize() > 0) {
			// 파일을 업로드 위치에 저장

			multipartFile.transferTo(new File(uploadfolder, multipartFile.getOriginalFilename()));
			vo.setFilename(multipartFile.getOriginalFilename());
		}
		noticeService.insertNotice(vo);
		return "redirect:/getNoticeList";
	}

	// 수정폼
	@RequestMapping("/updateNoticeForm")
	public String updateNoticeForm(Model model, NoticeVO vo) {
		model.addAttribute("notice", noticeService.getNotice(vo,false));
		return "notice/updateNotice";
	}

	// 수정처리
	@RequestMapping(value = "/updateNotice", method = RequestMethod.POST)
	public String updateClass(NoticeVO vo,HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("notice_file");

		if (multipartFile != null && multipartFile.getSize() > 0) {
			// 파일을 업로드 위치에 저장

			multipartFile.transferTo(new File(uploadfolder, multipartFile.getOriginalFilename()));
			vo.setFilename(multipartFile.getOriginalFilename());
		}
		noticeService.updateNotice(vo);
		return "redirect:/getNoticeList";
	}

	// 삭제
	@RequestMapping("/deleteNotice")
	public String deleteNotice(NoticeVO vo) {
		noticeService.deleteNotice(vo);
		return "redirect:/getNoticeList";
	}

}
