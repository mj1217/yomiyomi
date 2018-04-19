package com.yedam.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;


@Service //빈 등록
@Aspect	//Advice 클래스
public class BeforeAdvice {
	@Pointcut("execution(* com.yedam.app..*Impl.*(..))")
	public void allpointcut() {}
	
	@Before("allpointcut()")
	public void beforeLog(JoinPoint jp) {
		
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("[사전처리]로직 수행 전 동작" + method);
		if(args!=null && args.length>0) {
			System.out.println(args[0]);
		}
		
	}
}
