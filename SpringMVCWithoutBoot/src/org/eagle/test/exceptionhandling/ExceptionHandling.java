package org.eagle.test.exceptionhandling;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionHandling {
	@ExceptionHandler(Throwable.class)
	public String pageNotFoundException(Throwable e){
		return "/error/exception_page";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String noHandlerFoundException(NoHandlerFoundException e){
		return "/error/page_not_found";
	}
	
}
