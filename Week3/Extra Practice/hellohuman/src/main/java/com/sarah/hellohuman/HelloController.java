package com.sarah.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	// returns "Hello Human" if no name provided
	// returns "Hello first_name" if only first name provided
	// returns "Hello full_name" if both first & last name provided
	@RequestMapping("")
	public String giveName(
			@RequestParam(value = "first_name", required=false) String first_name,
			@RequestParam(value = "last_name", required=false) String last_name
			) {
		
	String full_name;
		
	if(first_name != null && last_name == null) {
		full_name = first_name;
	} else if (first_name != null && last_name != null) {
		full_name = first_name + " " + last_name;
	} else {
		full_name = "Human";
	}
	return "Hello " + full_name;
	}
}
