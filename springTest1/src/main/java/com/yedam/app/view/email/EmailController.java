package com.yedam.app.view.email;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.app.member.MemberService;
import com.yedam.app.member.MemberVO;

@Controller
public class EmailController {

	@Autowired
	SendEmailService emailService;

	@Autowired
	MemberService memberService;

	// 메일보내기 폼
	@RequestMapping("mailForm")
	public String mailForm() {
		return "email/mailForm";
	}

	// 메일 발송 처리
	@RequestMapping("mailSend")
	public void mailSend(HttpServletRequest request, HttpServletResponse response, MemberVO vo)
			throws IOException {
		//한글 깨지는 현상 방지
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// 아이디와 이메일 비교
		String member_id = "";
		String email = "";
		int size=8;
		MemberVO dbVO = (MemberVO) memberService.getMember_id(vo);
		if (dbVO != null && dbVO.getEmail().equals(vo.getEmail())) {
			EmailVO emailVO = new EmailVO();
			//password생성
			String tempPwd =  temporaryPassword (size);
			//변경된 페스워드를 db에 업데이트
			dbVO.setPwd2(tempPwd);
			memberService.changePwd(dbVO);
			
			// 보내는사람,받는사람,제목,내용
			emailVO.setFrom("jhshose@gmail.com"); // 보내는사람
			emailVO.setTo(vo.getEmail()); // 받는사람
			emailVO.setSubject("메일 발송"); // 제목
			emailVO.setContent("변경된 임시 비밀번호 " + dbVO.getPwd2()); // 내용

			emailService.send(emailVO);

			out.print("<script>");
			out.print("alert('메일을 성공적으로 발송했습니다.');");
			out.print("location.href='loginForm';");
			out.print("</script>");
		} else {
			out.print("<script>");
			out.print("alert('메일 발송 실패.');");
			out.print("history.go(-1);");
			out.print("</script>");
		}

	}
	
	// 임시 비밀번호 Random 생성
	public static String temporaryPassword(int size) {
			StringBuffer buffer = new StringBuffer();
			Random random = new Random();
			String chars[] = 
					"a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,0,1,2,3,4,5,6,7,8,9".split(",");
			for (int i = 0; i < size; i++) {
				buffer.append(chars[random.nextInt(chars.length)]);
			}
			return buffer.toString();
	}
	
	//소문자, 숫자형
	public static String randomValue(String type, int cnt) {
		StringBuffer strPwd = new StringBuffer();
		char str[] = new char[1];

		Random rnd = new Random();

		for (int i = 0; i < cnt; i++) {
			if (rnd.nextBoolean()) {
				strPwd.append((char) ((int) (rnd.nextInt(26)) + 97));
			} else {
				strPwd.append((rnd.nextInt(10)));
			}
		}
		return type;
	}
	
	
}
