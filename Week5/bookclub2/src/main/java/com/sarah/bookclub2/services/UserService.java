package com.sarah.bookclub2.services;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.sarah.bookclub2.models.User;
import com.sarah.bookclub2.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	// Get one user by email -- for checking if user exists in DB
	// Optional = may or may not return null
	public Optional<User> getByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	// check if user is in session
	public Optional<User> inSession(Long userId, HttpSession session){
		session.getAttribute(userId);
	}
	
	// Register and Login Methods
	
	public User register(User newUser, BindingResult result) {
		
		// create instance of potential user	
	}
}
