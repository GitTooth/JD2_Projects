package com.epam.testapp.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import org.apache.log4j.Logger;

@Aspect
@Component
public class LoggingAspect{
	
	private static final Logger logger = Logger.getLogger(LoggingAspect.class);
	
	@Pointcut("execution(* com.epam.testapp.dao.*.*(..))")
	private void forDAO() {}
	
	@Pointcut("execution(* com.epam.testapp.service.*.*(..))")
	private void forService() {}

	@Pointcut("forDAO() || forService()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		logger.info("====> calling method: " + method);
	}
}
