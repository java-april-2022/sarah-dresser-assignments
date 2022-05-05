package com.sarah.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sarah.authentication.models.LoginUser;
import com.sarah.authentication.models.User;

@Controller
public class MainController {
	
	/*
	 * @Autowired private UserService userService;
	 */
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String create(@Valid @ModelAttribute("newUser") User newUser, BindingResult results, Model model, HttpSession session) {
		// Add: register method in UserService
		// that will validate & create User
		if(results.hasErrors()) {
			// need to send empty LoginUser before
			// re-rendering page
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		// Add: store user ID in session
		return "redirect:/welcome";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult results, Model model, HttpSession session) {
		// once service is implemented:
		// User user = userService.login(newLogin, result);
		if(results.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		
		// Add: store ID from DB in session
		// and log them in
		return "redirect:/welcome";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "dashboard.jsp";
	}
}
