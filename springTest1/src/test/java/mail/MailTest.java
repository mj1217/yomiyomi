package mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

	public class MailTest {
		public static void main(String args[]) {
			SimpleEmail email = new SimpleEmail();
			// 메일서버 설정
			email.setCharset("euc-kr"); 			// 한글 인코딩
			email.setHostName("smtp.gmail.com"); 	// 보내는 메일(SMTP) 서버
			email.setSmtpPort(465); 				// 포트
			email.setAuthenticator(new DefaultAuthenticator("jhshose@gmail.com", "zjqfjtordwdbqrhx")); 	// 인증
			email.setSSLOnConnect(true); 			// SSL 필요
			try {
				email.addTo("horaengi486@naver.com", "조호섭"); // 수신자 추가
			} catch (EmailException e) {
				e.printStackTrace();
			}
			try {
				email.setFrom("jhshose@gmail.com", "jhshose"); // 보내는 사람
			} catch (EmailException e) {
				e.printStackTrace();
			}
			email.setSubject("임시 비밀번호"); // 메일 제목
			email.setContent("웹사이트에서 비밀번호를 변경해주시기 바랍니다.", "text/plain; charset=euc-kr"); // 메일 내용
			try {
				email.send();
			} catch (EmailException e) {
				e.printStackTrace();
			}
		}
	}