package com.yedam.app.common;

import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Service;

@Service //빈 등록
@Aspect	//Advice 클래스
public class AroundAdvice {

	
	@Around("BeforeAdvice.allpointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[around before] 로직 수행전");
		Object returnObj = pjp.proceed();  //서비스 메소드
		System.out.println("[around after] 로직 수행후");
		return returnObj;
		
	}

}
