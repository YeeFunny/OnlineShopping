package com.service;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class LoggingService {

	Logger logger = Logger.getLogger(LoggingService.class);
	
	@Around("execution(* com.controller.ProductController.*(..))")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		
		logger.info("Entering method " + pjp.getSignature());
		Object o = pjp.proceed();
		logger.info("Exiting method " + pjp.getSignature());
		return o;
	}
	
}
