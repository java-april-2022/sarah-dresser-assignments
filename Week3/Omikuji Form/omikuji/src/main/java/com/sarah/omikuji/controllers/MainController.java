package com.sarah.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submitOmikuji(
			@RequestParam(value="pickNum") int num,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="livingThing") String livingThing,
			@RequestParam(value="kindWords") String kindWords,
			HttpSession session
			) {
		// save to session
		session.setAttribute("pickNum", num);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("kindWords", kindWords);
		
		return "redirect:/omikuji/show";
	}

	@RequestMapping("/omikuji/show")
	public String showOmikuji(HttpSession session, Model model) {
		// get all attributes from session
		int num = (int) session.getAttribute("pickNum");
		String city = (String) session.getAttribute("city");
		String person = (String) session.getAttribute("person");
		String hobby = (String) session.getAttribute("hobby");
		String livingThing = (String) session.getAttribute("livingThing");
		String kindWords = (String) session.getAttribute("kindWords");
		
		// save session attributes to model
		model.addAttribute("pickNum", num);
		model.addAttribute("city", city);
		model.addAttribute("person", person);
		model.addAttribute("hobby", hobby);
		model.addAttribute("livingThing", livingThing);
		model.addAttribute("kindWords", kindWords);

		return "show.jsp";
	}
}
