package org.zerock.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect // 공통 관심사항
@Log4j
@Component
public class LogAdvice {
	
	// 리턴 X / org.zerock.service.SampleService 클래스 안에 있는 / 모든 메서드가 호출되면
	@Before("execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("-----------------------------");
	}
}
