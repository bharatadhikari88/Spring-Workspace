package org.eagle.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MVCController {

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

}
