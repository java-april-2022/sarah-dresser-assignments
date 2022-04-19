package com.sarah.controllerspractice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	@RequestMapping("")
	public String hello() {
		return "Hello World";
	}
	@RequestMapping("/world")
	public String world() {
		return "Class level annotations are cool";
	}
}
