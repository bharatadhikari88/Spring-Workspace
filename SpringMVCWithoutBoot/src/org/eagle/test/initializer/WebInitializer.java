package org.eagle.test.initializer;

import javax.servlet.ServletRegistration.Dynamic;

import org.eagle.test.config.AppConfig;
import org.eagle.test.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Create dynamic web project.
 * Add Gradle nature
 * create build.gradle
 * add dependence 
 * @author Bharat
 *
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		/**
		 * throw exception when error occur
		 */
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
		super.customizeRegistration(registration);
	}

}
