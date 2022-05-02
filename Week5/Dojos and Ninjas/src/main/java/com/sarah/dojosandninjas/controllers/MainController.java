package com.sarah.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sarah.dojosandninjas.services.DojoService;

@Controller
public class MainController {
	
	@Autowired
	private DojoService dojoService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojos")
	public String index() {
		return "index.jsp";
	}
}
