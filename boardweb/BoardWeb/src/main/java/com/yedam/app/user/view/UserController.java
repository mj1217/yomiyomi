package com.yedam.app.user.view;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.user.UserService;
import com.yedam.app.user.UserVO;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	//목록
	@RequestMapping("/getUserList")
	public String getUserList(Model model) {
		model.addAttribute("userList", userService.getUserList());
		return "user/getUserList" ;
	}
	
	//상세보기
	@RequestMapping("/getUser")
	public String getUser(Model model, UserVO vo) {
		model.addAttribute("user", userService.getUser(vo));
		return "user/getUser" ;
	}
	
	//등록폼
	@RequestMapping("/insertUserForm")
	public String insertUserForm() {
		return "user/insertUser";
	}
	
	//등록처리
	@RequestMapping("/insertUser")
	public String insertBoard(UserVO vo) {
		userService.insertUser(vo);
		return "redirect:/getUserList";
	}
	
	//수정폼
	@RequestMapping("/updateUserForm")
	public String updateUserForm(Model model, UserVO vo) {
		model.addAttribute("user", userService.getUser(vo));
		return "user/updateUser";
	}
		
	//수정처리
	@RequestMapping("/updateUser")
	public String updateUser( UserVO vo) {
		userService.updateUser(vo);
		return "redirect:/getUserList";
	}
	//삭제처리
	@RequestMapping("/deleteUser")
	public String deleteUser( UserVO vo) {
		userService.deleteUser(vo);
		return "redirect:/getUserList";
	}
	
	//로그인폼으로
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "user/login";
	}
	
	//로그인
	@RequestMapping("/login")
	public String login(@ModelAttribute("user") UserVO vo, HttpSession session) {
		if(userService.login(vo)) {
			session.setAttribute("user", userService.getUser(vo));
			return "redirect:/getBoardList";
		}else {
			return "user/login";
		}
	}

	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/getBoardList";
	}
	
	//아이디 중복체크(ajax)
	@RequestMapping("/dupCheck")
	@ResponseBody
	public Map<String,Boolean> dupCheck(UserVO vo) {
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		//서비스 한건 조회
		UserVO vv = userService.getUser(vo);
		//id가 있으면 false
		if(vv != null) {
			map.put("result", false);
		}//id가 없으면 true
		else {
			map.put("result", true);
		}
		return map;
	}
	
	


}
