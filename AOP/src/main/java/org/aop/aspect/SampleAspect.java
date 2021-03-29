package org.aop.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("sampleAspect")
@Aspect
public class SampleAspect {
	
	/** 
	 * point cut will be called for all method 
	 * where 
	 * return type is void
	 * method name is anything
	 * params are any
	 * and
	 * method called from configuration package
	 */
	@Pointcut("execution(void org.aop.joinpoints.SampleJoinPoint.*(..)) && within(org.aop.configuration.*)")
	private void pointCutMethod1(){};
	
	/**
	 * "args" used to capture input args of method
	 * @param text
	 */
	@Pointcut("execution(* org.aop.joinpoints.SampleJoinPoint.method2(String)) && args(text)")
	private void pointCutMethod2(String text){};


	@Before("@annotation(org.aop.annotation.Loggable)")
	private void beforeJoinPointMethod1(JoinPoint joinPoint){
		System.out.println("Before method for Looggable annotation");
	}
	
	@Before("pointCutMethod1()")
	private void beforeJoinPointMethod1(JoinPoint joinPoint){
		System.out.println("Before method");
	}

	/**
	 * It will be executed for both normal and exceptional termination.
	 * @param joinPoint
	 * @param i
	 */
	@After("execution(* org.aop.joinpoints.SampleJoinPoint.method1(int)) && args(i)")
	private void afterJoinPointMethod1(JoinPoint joinPoint,int i){
		System.out.println("After Method1 with i :- " + i);
	}

	//@AfterReturning  :- Normal termination
	//@AfterThrowing :- Exceptional termination
	
	@Around("pointCutMethod2(text)")
	private void aroundJoinPointMethod2(ProceedingJoinPoint jp,String text){
		System.out.println("before method 2");
		text+=" Singh";
		try {
			jp.proceed(new Object[]{text});
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("after method 2");
	}

}
