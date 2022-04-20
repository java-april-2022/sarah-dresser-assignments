package com.sarah.daikichiroutes;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	@RequestMapping("")
	public String greeting() {
		return "Welcome!";
	}
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow an opportunity will arise, so be sure to be open to new ideas!";
	}
	// adding @PathVariable routes
	@RequestMapping("/travel/{city}")
	public String travel(@PathVariable("city") String city) {
		return String.format("Congratulations! You will soon travel to %s!", city);
	}
}
