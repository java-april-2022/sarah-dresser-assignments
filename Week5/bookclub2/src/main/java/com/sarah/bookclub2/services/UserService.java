package com.sarah.bookclub2.services;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.sarah.bookclub2.models.LoginUser;
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
	// adapted from Week 6 Lesson 1 Lecture
	public User fromSession(HttpSession session){
		if(session.getAttribute("userId") == null) {
			return null;
		}
		return userRepo.findById((Long) session.getAttribute("userId")).get();
	}
	
	// Register and Login Methods
	// from: https://login.codingdojo.com/m/325/9950/74045
	
	public User register(User newUser, BindingResult result) {
		
		// creating instance of potential user
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		
		/*
		 * System.out.println("potentialUser = " + potentialUser);
		 * System.out.println("Email = " + newUser.getEmail());
		 */
		
		// if email is already in database,
		// reject user
		if(!potentialUser.isEmpty()) {
			System.out.println("From UserService: email already in DB");
			result.rejectValue("email", "matches", "An account with that email already exists");
		}
		
		// reject if password != confirm
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			System.out.println("From UserService: passwords do not match");
			result.rejectValue("confirm", "matches", "Passwords must match");
		}
		
		// if errors in form, return null
		if(result.hasErrors()) {
			return null;
		}
		
		// if all checks pass, continue
		
		// hash pw & save to user
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		
		// saving to repository
		return userRepo.save(newUser);
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		// creating instance of potential user
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
		
		// find user in DB by email
		if(potentialUser == null) {
			System.out.println("From UserService: email not found");
			result.rejectValue("email", "matches", "Email not found");
		}
		
		// continue
		// user exists, retrieve from DB
		User user = potentialUser.get();
		
		// reject if BCrypt password does not match
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Invalid Password--try again!");
		}
		
		// if any errors, return null
		if(result.hasErrors()) {
			System.out.println("From UserService: errors detected");
			return null;
		}
		
		// all is good. continue & return user
		return user;
	}
}
