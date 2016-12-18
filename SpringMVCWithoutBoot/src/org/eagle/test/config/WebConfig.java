package org.eagle.test.config;

import java.util.ArrayList;
import java.util.List;

import org.eagle.test.controller.TestController;
import org.eagle.test.exceptionhandling.ExceptionHandling;
import org.eagle.test.filter.AuthFilter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc  //in absence of this annotation  "string" is not returning from rest controller
@ComponentScan(basePackageClasses={TestController.class,AuthFilter.class,ExceptionHandling.class})
public class WebConfig implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;

	@Bean
	public ViewResolver viewResolverNonStatic(){
		InternalResourceViewResolver nonStaticViewResolver = new InternalResourceViewResolver();
		nonStaticViewResolver.setPrefix("/WEB-INF/views/");
		nonStaticViewResolver.setSuffix(".jsp");
		nonStaticViewResolver.setOrder(0);
		
		UrlBasedViewResolver staticViewResolver = new UrlBasedViewResolver();
		staticViewResolver.setPrefix("/static-views/");
		staticViewResolver.setSuffix(".jsp");
		staticViewResolver.setViewClass(InternalResourceView.class);
		staticViewResolver.setOrder(1);
		
		List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();
		viewResolvers.add(nonStaticViewResolver);
		viewResolvers.add(staticViewResolver);
		
		ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
		contentNegotiatingViewResolver.setViewResolvers(viewResolvers);
		contentNegotiatingViewResolver.setApplicationContext(applicationContext);
		return contentNegotiatingViewResolver;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	
}
