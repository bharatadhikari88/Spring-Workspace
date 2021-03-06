package org.eagle.student.management.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.eagle.student.management.filter.LoggingFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Spring provide 2 type of context
 * 1. Application context :- Which hold components and services
 * 2. Web context :- which hold controllers
 *
 * https://www.baeldung.com/spring-boot-context-hierarchy
 *
 * Spring Validators and BindingResults.
 */
@SpringBootApplication
public class SMInitializer implements ServletContextInitializer{
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SMInitializer.class, args);
		DispatcherServlet dispatcherServlet = (DispatcherServlet)ctx.getBean("dispatcherServlet");
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
		
	}

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		servletContext.setInitParameter("throwExceptionIfNoHandlerFound", "true");
	}
}
