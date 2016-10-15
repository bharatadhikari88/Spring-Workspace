package org.eagle.spring;
import org.sample.beans.BCAStudent;
import org.sample.beans.HomeAddress;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses={Student.class,HomeAddress.class,BCAStudent.class}) //package of class is treated as base package
//@ComponentScan(basePackages={"org.test.spring","org.eagle.spring"}))//org.eagle.spring
public class HelloConfiguration {
	
	@Bean
	@Qualifier("name")
	public String getName(){
		return "ABC";
	}
	
	/*@Bean
	public IStudent getStudent(){
		return new Student();
	}*/
	
	/*@Bean
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public IStudent getStudentByName(String abc){
		return new Student(abc);
	}*/
	/*
	@Bean
	public IAddress getAddress(){
		return new Address();
	}*/
}
