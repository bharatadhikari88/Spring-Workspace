package org.eagle.test.viewresolver;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class CustomViewResolver implements ViewResolver{
	private  final InternalResourceViewResolver staticViewResolver;
	private  final InternalResourceViewResolver nonStaticViewResolver;
	public CustomViewResolver(){
		nonStaticViewResolver = new InternalResourceViewResolver();
		nonStaticViewResolver.setPrefix("/WEB-INF/views/");
		nonStaticViewResolver.setSuffix(".jsp");
		nonStaticViewResolver.setOrder(1);
		
		staticViewResolver = new InternalResourceViewResolver();
		staticViewResolver.setPrefix("/static-views/");
		staticViewResolver.setSuffix(".jsp");
		staticViewResolver.setOrder(2);
	}

	@Override
	public View resolveViewName(String viewName, Locale locale)
			throws Exception {
		View view = staticViewResolver.resolveViewName(viewName, locale);
		if(view == null){
			view = nonStaticViewResolver.resolveViewName(viewName, locale);
		}
		return view;
	}

}
