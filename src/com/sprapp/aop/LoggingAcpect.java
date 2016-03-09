package com.sprapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAcpect {

	@After("execution(public * com.sprapp.service.TempTableServiceImpl.*(..))")
	public void logAfter(JoinPoint joinPoint) {

		System.out.println(" @After is running!");
		System.out.println(" End Method : " + joinPoint.getSignature().getName());
		System.out.println("***************************************************************");

	}

	@Before("execution(public * com.sprapp.service.TempTableServiceImpl.*(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("@Before  is running!");
		System.out.println(" Start  Method : " + joinPoint.getSignature().getName());
		System.out.println("***************************************************************");

	}

}
