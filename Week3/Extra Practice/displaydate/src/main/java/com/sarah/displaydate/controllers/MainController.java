package com.sarah.displaydate.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String getDate(Model model) {
		Date currentDate = new Date();
		model.addAttribute("date", currentDate);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String getTime() {
		return "time.jsp";
	}
}