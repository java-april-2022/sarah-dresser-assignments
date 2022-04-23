package com.sarah.displaydate.controllers;

import java.util.Date;
import java.text.SimpleDateFormat;

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
		
		// using documentation: https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
		SimpleDateFormat dayNameFormat = new SimpleDateFormat("EEEE");
		SimpleDateFormat dayFormat = new SimpleDateFormat("d");
		SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
		SimpleDateFormat yearFormat = new SimpleDateFormat("y");
		
		Date date = new Date();
		
		String dayNameString = dayNameFormat.format(date);
		String dayString = dayFormat.format(date);
		String monthString = monthFormat.format(date);
		String yearString = yearFormat.format(date);
		
		if(dayString.endsWith("1")) {
			dayString += "st";
		} else if(dayString.endsWith("2")) {
			dayString += "nd";
		} else if(dayString.endsWith("3")) {
			dayString += "rd";
		} else {
			dayString += "th";
		}
		
		String dateString = String.format("%s, the %s of %s, %s", dayNameString, dayString, monthString, yearString);
		
		model.addAttribute("dateString", dateString);
		
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String getTime(Model model) {
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
		
		Date time = new Date();
		
		String timeString = timeFormat.format(time);
		
		model.addAttribute("timeString", timeString);
		
		return "time.jsp";
	}
}