package com.yedam.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;


@Service //빈 등록
@Aspect	//Advice 클래스
public class AfterAdvice {
	
	
	@AfterReturning(pointcut="BeforeAdvice.allpointcut()",returning="returnObj")
	public void finallyLog(JoinPoint jp, Object returnObj) {
		
		String method = jp.getSignature().getName(); //메소드명 확인
		System.out.println("[사후처리] 무조건 동작 " + method); //리턴결과확인
		System.out.println("리턴결과:"+returnObj);
		
	}

}
