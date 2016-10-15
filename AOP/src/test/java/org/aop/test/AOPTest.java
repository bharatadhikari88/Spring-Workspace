package org.aop.test;

import org.aop.configuration.AspectConfiguration;
import org.aop.joinpoints.SampleJoinPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AspectConfiguration.class)
public class AOPTest {

	@Autowired
	private SampleJoinPoint sampleJoinPoint;
	
	@Test
	public void test(){
		sampleJoinPoint.method1();
		sampleJoinPoint.method1(2);
		sampleJoinPoint.method2("Bharat");
	}
}
