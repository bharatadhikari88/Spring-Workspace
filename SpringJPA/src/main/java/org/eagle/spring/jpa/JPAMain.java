package org.eagle.spring.jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JPAMain {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.register(JPAConfiguration.class);
		annotationConfigApplicationContext.refresh();
	}

}
