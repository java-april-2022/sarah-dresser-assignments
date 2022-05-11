package com.sarah.bookclub2.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sarah.bookclub2.models.LoginUser;
import com.sarah.bookclub2.models.User;
import com.sarah.bookclub2.services.UserService;

@Controller
public class MainController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String index(Model model) {
		// binding empty User & LoginUser objects to save form data
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";	
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		
		// register method from UserService
		User user = userService.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		
		// if no errors, continue
		// storing user ID in session
		session.setAttribute("userId", user.getId());
		
		return "redirect:/books";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		
		// login method from UserService
		User user = userService.login(newLogin, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		
		// if no errors, continue
		// storing user ID in session
		session.setAttribute("userId", user.getId());
		
		return "redirect:/books";
	}
	
	@GetMapping("/books")
	public String home(Model model, HttpSession session) {
		
		User user = userService.fromSession(session);
		
		// userService method to check if user is in session
		if (user == null) {
			return "redirect:/";
		}
		// else, save user info to model
		model.addAttribute("user", user);
		return "dashboard.jsp";
	}
}
