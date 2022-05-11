package com.sarah.bookclub2.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sarah.bookclub2.models.Book;
import com.sarah.bookclub2.models.LoginUser;
import com.sarah.bookclub2.models.User;
import com.sarah.bookclub2.services.BookService;
import com.sarah.bookclub2.services.UserService;

@Controller
public class MainController {

	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;
	
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
		// save all books to render in table
		model.addAttribute("allBooks", bookService.getAll());
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/books/new")
	public String newBook(Model model, HttpSession session) {
		User user = userService.fromSession(session);
		// userService method to check if user is in session
		if (user == null) {
			return "redirect:/";
		}
		// else, save user info to model
		model.addAttribute("user", user);
		// binding empty Book object
		model.addAttribute("newBook", new Book());
		return "new.jsp";
	}
	
	@PostMapping("/books/save")
	public String saveBook(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		bookService.save(newBook);
		return "redirect:/books";
	}
	
	@GetMapping("/books/{id}")
	public String view(@PathVariable("id") Long id, Model model, HttpSession session) {
		User user = userService.fromSession(session);
		// userService method to check if user is in session
		if (user == null) {
			return "redirect:/";
		}
		// else, save user info to model
		model.addAttribute("user", user);
		model.addAttribute("book", bookService.getById(id));
		return "view.jsp";
	}
	
	@GetMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		User user = userService.fromSession(session);
		// userService method to check if user is in session
		if (user == null) {
			return "redirect:/";
		}
		// else, save user info to model
		model.addAttribute("user", user);
		model.addAttribute("book", bookService.getById(id));
		return "edit.jsp";
	}
	
	@PostMapping("/books/{id}/update")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		bookService.save(book);
		return "redirect:/books/{id}";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/";
	}
}
