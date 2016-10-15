package org.eagle.spring;
import org.sample.interfaces.IStudent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class HelloMain {
	

	public static void main(String[] args) {
		/** It will create spring container or context **/
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(HelloConfiguration.class);
		ctx.refresh();
		ctx.getBean("OfficeAddress");

		Student student1 = (Student)ctx.getBean(IStudent.class);//MCAStudent
		student1.setName("bharat");
		student1 = (Student)ctx.getBean(IStudent.class);
		Student student = (Student)ctx.getBean(IStudent.class,"xyz");
		student.setName("singh");
		student = (Student)ctx.getBean(IStudent.class,"xyz");
		System.out.println();
		
		/** Another spring container **/
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext();
		ctx2.register(HelloConfiguration.class);
		ctx2.refresh();
		student = (Student)ctx2.getBean(IStudent.class,"xyz");
		System.out.println();
	}

}
