package com.yedam.app.member;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yedam.app.member.MemberService;

@Controller
public class LoginController {

	@Autowired
	MemberService memberService;
	
	//로그인폼
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	//로그인
	@RequestMapping("/login")
	public String login(@ModelAttribute("member") MemberVO vo, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 인증 처리");
		if(memberService.login(vo)) {
			session.setAttribute("memberVO", memberService.getMember_id(vo));
			return "redirect:/";
		} else {
			return "member/loginForm";
		}
	}
	
	/*//로그인 체크
	@RequestMapping(value="loginCheck", method = RequestMethod.POST)
	public ModelAndView loginCheck (@ModelAttribute MemberVO vo, HttpSession session) {
		boolean result = memberService.loginCheck(vo, session);
		ModelAndView mav = new ModelAndView();
		 if (result == true) { // 로그인 성공
			 mav.setViewName("redirect:/"); //메인으로
			 session.setAttribute("member_id",vo.getMember_id());
	        }
		return mav; 
	}
	*/
	//로그아웃 
		@RequestMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
		
}
	
	

