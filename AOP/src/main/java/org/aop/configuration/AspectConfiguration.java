package org.aop.configuration;

import org.aop.aspect.SampleAspect;
import org.aop.joinpoints.SampleJoinPoint;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP is used for Some of the common crosscutting concerns
 * like logging, transaction management, data validation, security
 * etc.
 *
 * Two ways to create AOP proxy classes
 * 1. JDK proxy
 * 2. CGLIB proxy
 *
 * Weaving :- when proxy classes will generate compile time or runtime time.
 * Spring AOP performs weaving at the runtime.
 */

@ComponentScan(basePackageClasses={SampleAspect.class,SampleJoinPoint.class})
@EnableAspectJAutoProxy(proxyTargetClass=false)//JDK proxy 
public class AspectConfiguration {

}
