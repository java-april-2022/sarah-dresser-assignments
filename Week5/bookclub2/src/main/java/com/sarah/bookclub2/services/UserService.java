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
	public boolean inSession(HttpSession session){
		if(session.getAttribute("userId") == null) {
			return false;
		}
		return true;
	}
	
	// Register and Login Methods
	// from: https://login.codingdojo.com/m/325/9950/74045
	
	public User register(User newUser, BindingResult result) {
		
		// creating instance of potential user
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		
		// if email is already in database,
		// reject user
		if(potentialUser != null) {
			System.out.println("From UserService: email already in DB");
			result.rejectValue("email", "An account with that email already exists");
		}
		
		// reject if password != confirm
		if(newUser.getPassword() != newUser.getConfirm()) {
			 System.out.println("From UserService: passwords do not match");
			 result.rejectValue("confirm", "Passwords must match");
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
			result.rejectValue("email", "Email not found");
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
