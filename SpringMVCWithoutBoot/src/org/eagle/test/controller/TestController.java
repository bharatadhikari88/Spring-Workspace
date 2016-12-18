package org.eagle.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@RequestMapping("/")
	public String test(){
		return "test";
	}
	
	/** jackson required in class path**/
	@RequestMapping("/json")
	public Map<String,String> json(){
		Map<String,String> map = new HashMap<String, String>();
		map.put("1", "one");
		return map;
	}
	
	@RequestMapping(path ="/xml",produces=MediaType.APPLICATION_XML_VALUE)
	public Map<String,String> xml(){
		Map<String,String> map = new HashMap<String, String>();
		map.put("1", "one");
		return map;
	}
	
	@RequestMapping(value = { "/exception" })
	public String throwException() throws Exception{
		throw new Exception("exception test");
	}
}
