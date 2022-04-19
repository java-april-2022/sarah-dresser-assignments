package com.sarah.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
// annotation?

@RestController
public class FirstprojectApplication {
	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
		
	}
	
	@RequestMapping("/")
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping("/new_route")
	public String myMessage() {
		return "Wow, you found my secret page!";
	}
}