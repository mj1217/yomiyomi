package com.yedam.app.view.classes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.yedam.app.classes.ClassService;
import com.yedam.app.classes.ClassVO;
import com.yedam.app.common.Paging;
import com.yedam.app.consult.ConsultVO;
import com.yedam.app.member.MemberService;
import com.yedam.app.member.MemberVO;

@Controller
public class ClassController {

	@Autowired
	ClassService classService;

	@Autowired
	MemberService memberService;

	@Value("${file.uploadfolder}")
	String uploadfolder;

	// 목록
	@RequestMapping("/getClassList")
	public String getClassList(Model model, ClassVO vo, Paging paging, HttpSession session) {
		
		// 전체 레코드 건수
		paging.setPageUnit(5);
		paging.setTotalRecord(classService.getCount(vo));

		// vo의 first, last setting
		vo.setFirst(paging.getFirst());
		vo.setLast(paging.getLast());

		// 결과저장
		model.addAttribute("classList", classService.getClassList(vo));
		model.addAttribute("paging", paging);

		return "class/getClassList";
	}

	// 등록폼
	@RequestMapping(value = "/insertClass", method = RequestMethod.GET)
	public String insertClassForm() {
		return "class/insertClass";
	}

	// 등록처리
	@RequestMapping(value = "/insertClass", method = RequestMethod.POST)
	public String insertClass(ClassVO vo, HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 첨부파일이 있는지 확인
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("attach_file");

		if (multipartFile != null && multipartFile.getSize() > 0) {
			// 파일을 업로드 위치에 저장

			multipartFile.transferTo(new File(uploadfolder, multipartFile.getOriginalFilename()));
			vo.setTimeTable(multipartFile.getOriginalFilename());
		}
		classService.insertClass(vo);
		return "redirect:/getClassList";
	}

	// 상세보기
	@RequestMapping("/getClass/{cl_no}")
	public ModelAndView getClass(@PathVariable Integer cl_no, HttpSession session) {
		ClassVO vo = new ClassVO();
		vo.setCl_no(cl_no);

		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_id", ((MemberVO) session.getAttribute("memberVO")).getMember_id());*/

		ModelAndView mv = new ModelAndView();
		mv.addObject("cl", classService.getClass(vo));
		mv.setViewName("class/getClass");
		return mv;
	}
	/*
	 * @RequestMapping("/getClass") public String getClass(Model model, Integer
	 * cl_no) { ClassVO vo = new ClassVO(); vo.setCl_no(cl_no);
	 * model.addAttribute("cl", classService.getClass(vo)); return "class/getClass";
	 * }
	 */

	// 수정폼
	@RequestMapping("/updateClassForm")
	public String updateClassForm(Model model, ClassVO vo) {
		model.addAttribute("cl", classService.getClass(vo));
		return "class/updateClass";
	}

	// 수정처리
	@RequestMapping("/updateClass")
	public String updateClass(ClassVO vo, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 첨부파일이 있는지 확인
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("attach_file");

		if (multipartFile != null && multipartFile.getSize() > 0) {
			// 파일을 업로드 위치에 저장

			multipartFile.transferTo(new File(uploadfolder, multipartFile.getOriginalFilename()));
			vo.setTimeTable(multipartFile.getOriginalFilename());
		}
		classService.updateClass(vo);
		return "redirect:/getClassList";
	}

	// 삭제
	@RequestMapping("/deleteClass")
	public String deleteClass(ClassVO vo) {
		classService.deleteClass(vo);
		return "redirect:/getClassList";
	}
	
	private String getBrowser(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		if (header.indexOf("MSIE") > -1) {
			return "MSIE";
		} else if (header.indexOf("Trident") > -1) { // IE11 문자열 깨짐 방지
			return "Trident";
		} else if (header.indexOf("Chrome") > -1) {
			return "Chrome";
		} else if (header.indexOf("Opera") > -1) {
			return "Opera";
		}
		return "Firefox";
	}

	// Disposition 지정
	private void setDisposition(String filename, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String browser = getBrowser(request);
		String dispositionPrefix = "attachment; filename=";
		String encodedFilename = null;
		if (browser.equals("MSIE")) {
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Trident")) { // IE11 문자열 깨짐 방지
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Firefox")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Opera")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Chrome")) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < filename.length(); i++) {
				char c = filename.charAt(i);
				if (c > '~') {
					sb.append(URLEncoder.encode("" + c, "UTF-8"));
				} else {
					sb.append(c);
				}
			}
			encodedFilename = sb.toString();
		} else {
			throw new IOException("Not supported browser");
		}
		response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);
		if ("Opera".equals(browser)) {
			response.setContentType("application/octet-stream;charset=UTF-8");
		}
	}

	// 다운로드
	@RequestMapping(value = "/FileDown")
	public void cvplFileDownload(@RequestParam String attachField, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		File uFile = new File(uploadfolder, attachField);
		long fSize = uFile.length();
		if (fSize > 0) {
			String mimetype = "application/x-msdownload";
			response.setContentType(mimetype);
			// response.setHeader("Content-Disposition", "attachment;
			// filename=\"" + URLEncoder.encode(fvo.getOrignlFileNm(), "utf-8") + "\"");
			setDisposition(attachField, request, response);
			BufferedInputStream in = null;
			BufferedOutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(uFile));
				out = new BufferedOutputStream(response.getOutputStream());
				FileCopyUtils.copy(in, out);
				out.flush();
			} catch (IOException ex) {
			} finally {
				in.close();
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
		} else {
			response.setContentType("application/x-msdownload");
			PrintWriter printwriter = response.getWriter();
			printwriter.println("<html>");
			printwriter.println("<h2>Could not get file name:<br>" + attachField + "</h2>");
			printwriter.println("<center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
			printwriter.println("&copy; webAccess");
			printwriter.println("</html>");
			printwriter.flush();
			printwriter.close();
		}
	}
}
