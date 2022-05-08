package com.sarah.bookclub.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;

import com.sarah.bookclub.models.Book;
import com.sarah.bookclub.models.LoginUser;
import com.sarah.bookclub.models.User;
import com.sarah.bookclub.service.BookService;
import com.sarah.bookclub.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;

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
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult results, Model model, HttpSession session) {
		
		User user = userService.login(newLogin, results);
		// checking for errors in form
		if(results.hasErrors()) {
			// binding empty object to JSP
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		
		// continue, get ID from DB, store in session
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
		model.addAttribute("allBooks", bookService.getAllBooks());
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
	
	@PostMapping("/books/add")
	public String addBook(@Valid @ModelAttribute("newBook") Book newBook, BindingResult results) {
		// check for errors
		if(results.hasErrors()) {
			return "new.jsp";
		}
		bookService.saveBook(newBook);
		return "redirect:/books";
	}
	
	@GetMapping("/books/{id}")
	public String view(@PathVariable("id") Long id, Model model, HttpSession session) {
		// checking user is logged in(session)
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("book", bookService.getById(id));
		model.addAttribute("userId", session.getAttribute("userId"));
		return "view.jsp";
	}
	
	@GetMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Book book = bookService.getById(id);
		model.addAttribute("book", book);
		return "edit.jsp";
	}
	
	@PostMapping("/books/update/{id}")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		bookService.saveBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/";
	}
}
