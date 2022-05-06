package com.sarah.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sarah.bookclub.models.Book;
import com.sarah.bookclub.models.LoginUser;
import com.sarah.bookclub.models.User;
import com.sarah.bookclub.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index(Model model) {
		
		// binding empty User & LoginUser objects to JSP to capture form input
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult results, Model model, HttpSession session){
		
		// Register method from UserService
		User user = userService.register(newUser, results);
		
		if(results.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		
		// if no errors, continue
		// storing user ID in session
		session.setAttribute("userId", user.getId());
		
		return "redirect:/books";
	}
	
	@GetMapping("/books")
	public String home(Model model, HttpSession session) {
		
		// checking user is logged in(session)
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
			
		// getting user info from session
		// & saving in model
		model.addAttribute("user", userService.findById((Long) session.getAttribute("userId")));
		return "dashboard.jsp";
	}

	@GetMapping("/books/new")
	public String newBook(Model model, HttpSession session) {
		
		// binding empty Book object
		model.addAttribute("newBook", new Book());
		// adding poster(user)id from session
		model.addAttribute("sessionId", session.getAttribute("userId"));
		return "new.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/";
	}
}
