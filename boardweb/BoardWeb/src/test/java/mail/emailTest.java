package mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class emailTest {
	public static void main(String args[]) {
		SimpleEmail email = new SimpleEmail();
		// 메일서버 설정
		email.setCharset("euc-kr"); // 한글 인코딩
		email.setHostName("smtp.gmail.com"); // 보내는 메일(SMTP) 서버
		email.setSmtpPort(465); // 포트
		email.setAuthenticator(new DefaultAuthenticator("k.miji1217@gmail.com", "sxpdsgqxvmovhrvd")); // 인증
		email.setSSLOnConnect(true); // SSL 필요
		try {
			email.addTo("mj_1217@naver.com", "사람이름?"); // 수신자 추가
		} catch (EmailException e) {
			e.printStackTrace();
		}
		try {
			email.setFrom("k.miji1217@gmailm.com", "Me"); // 보내는 사람
		} catch (EmailException e) {
			e.printStackTrace();
		}
		email.setSubject("메일전송테스트"); // 메일 제목
		email.setContent("simple 메일 Test입니다", "text/plain; charset=euc-kr"); // 메일 내용
		try {
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}