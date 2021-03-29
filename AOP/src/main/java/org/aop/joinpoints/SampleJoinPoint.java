package org.aop.joinpoints;

import org.springframework.stereotype.Component;

@Component("sampleJoinPoint")
public class SampleJoinPoint {
	
	public void method1(){
		System.out.println("Inside Method1 with no parameter");
	}
	
	public int method1(int i){
		System.out.println("Inside Method1 with param");
		return i;
	}

	@Loggable
	public void method2() throws Exception{
		System.out.println("Inside Method2");
		throw new Exception("Exception");
	}
	
	public void method2(String text){
		System.out.println("Inside Method2 " + text);
	}

}
