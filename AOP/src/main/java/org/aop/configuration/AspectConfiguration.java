package org.aop.configuration;

import org.aop.aspect.SampleAspect;
import org.aop.joinpoints.SampleJoinPoint;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackageClasses={SampleAspect.class,SampleJoinPoint.class})
@EnableAspectJAutoProxy(proxyTargetClass=false)//JDK proxy 
public class AspectConfiguration {

}
