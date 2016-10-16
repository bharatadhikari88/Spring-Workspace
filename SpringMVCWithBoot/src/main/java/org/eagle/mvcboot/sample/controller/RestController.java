package org.eagle.mvcboot.sample.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Default return type is JSON.
 * jackson jar is required in class path.
 * 
 * @RestController is @Controller + @ResponseBody
 * 
 * @ResponseBody is use to return produce type default is json.
 * when @ResponseBody is used view Resolver is ignored on return value.
 * 
 * @author Bharat
 *
 */

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@RequestMapping("/test")
	public String test(){
		return "test";
	}
	
	@RequestMapping("/json")
	public Map<String, String> json(){
		Map<String, String> json = new HashMap<String, String>();
		json.put("Name", "Bharat");
		json.put("Last name", "Adhikari");
		return json;
	}

}
