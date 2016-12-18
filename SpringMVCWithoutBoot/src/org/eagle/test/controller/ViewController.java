package org.eagle.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping("/static")
	public String staticPage(){
		return "static";
	}
	
	@RequestMapping("/nonstatic")
	public String nonStaticPage(){
		return "nonstatic";
	}
}
