package com.sarah.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sarah.authentication.models.LoginUser;
import com.sarah.authentication.models.User;
import com.sarah.authentication.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index(Model model) {
		
		// binding empty User & LoginUser objects
		// to JSP to capture form input
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String create(@Valid @ModelAttribute("newUser") User newUser, BindingResult results, Model model, HttpSession session) {
		
		// Register method in UserService
		User user = userService.register(newUser, results);
				
		if(results.hasErrors()) {
			// send empty LoginUser before re-rendering page
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}

		// store user ID in session
		session.setAttribute("userId", user.getId());
		System.out.println("Session =" + session.getAttribute("userId"));
		
		return "redirect:/welcome";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult results, Model model, HttpSession session) {

		User user = userService.login(newLogin, results);
		
		if(results.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		
		// Add: store ID from DB in session
		// and log them in
		session.setAttribute("userId", user.getId());
		
		return "redirect:/welcome";
	}
	
	@GetMapping("/welcome")
	public String welcome(HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
//		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findById((Long) session.getAttribute("userId"));
		model.addAttribute("user", user);
		return "dashboard.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
