package org.eagle.student.management.initializer;

import org.eagle.student.management.controller.SMController;
import org.eagle.student.management.exceptionhandling.ExceptionHandling;
import org.eagle.student.management.filter.LoggingFilter;
import org.eagle.student.management.interceptor.AuthenticationInterceptor;
import org.eagle.student.management.interceptor.LoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = { SMController.class,
		LoggingInterceptor.class, LoggingFilter.class,ExceptionHandling.class })
public class SMConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private AuthenticationInterceptor authenticationInterceptor;

	@Autowired
	private LoggingInterceptor LoggingInterceptor;

	@Autowired
	@Value("${server.contextPath}")
	private String contextPath;

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	/**
	 * global interceptors are executed first and than ordered maintained as per
	 * registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		/** global **/
		registry.addInterceptor(LoggingInterceptor);
		/** ordered **/
		// registry.addInterceptor(LoggingInterceptor).addPathPatterns("/*");
		registry.addInterceptor(authenticationInterceptor).addPathPatterns(
				"/login");

		// super.addInterceptors(registry);
	}
	
}
