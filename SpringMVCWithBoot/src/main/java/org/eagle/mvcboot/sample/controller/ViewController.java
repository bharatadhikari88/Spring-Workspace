package org.eagle.mvcboot.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * view controller methods return string which are resolve by ViewResolver
 * 
 * @author Bharat
 *
 */
@Controller
public class ViewController {

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String login,
			@RequestParam String password, Model model) {
		model.addAttribute("login", login);
		model.addAttribute("password", password);
		return "success";
	}

}
