package com.sarah.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	// index() returns "Hello Human" if no name provided, else "Hello Name"
	@RequestMapping("/")
	public String index(@RequestParam(value = "q", required=false) String name) {
	if(name == null) {
		return "Hello Human";
	} else {
		return "Hello " + name;	
	}
	}
}
