package org.eagle.student.management.exceptionhandling;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionHandling {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String pageNotFoundException(NoHandlerFoundException e){
		return "/error/page_not_found";
	}

}
