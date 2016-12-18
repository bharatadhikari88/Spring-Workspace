package org.eagle.student.management.interceptor;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Difference b/w filter and interceptor
 * 1. filter can modify request and than forward it to filterChain.doFilter()
 * 2. filter doesn't have after view rendered method(afterCompletion)
 * 
 * Interceptors
 * 1. in multiple interceptor calling order prehandler1, prehandler2,
 *  posthandler2, posthandler1, completion 2, completion1
 *  
 *  2. global interceptors are executed first and then ordered by interceptor added in registry.
 *  check SMConfig
 *  
 *  3. interceptor pre return false to stop
 * 
 * @author Bharat
 *
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("Authentication pre handler");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Authentication post handler");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("Authentication after completion");
	}

}
