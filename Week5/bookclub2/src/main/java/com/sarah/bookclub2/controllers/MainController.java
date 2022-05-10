package com.sarah.bookclub2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sarah.bookclub2.services.UserService;

@Controller
public class MainController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";	
	}
}
