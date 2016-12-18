package org.eagle.student.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SMController {

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String showIndexPage(@RequestParam String login,
			@RequestParam String password) {
		return "index";
	}

	@RequestMapping(value = { "/open/{page}" }, method = RequestMethod.GET)
	public String openIndex(@PathVariable String page) {
		return page;
	}
	
	@RequestMapping(value = { "/exception" })
	public String throwException() throws Exception{
		throw new Exception("exception test");
	}

}
