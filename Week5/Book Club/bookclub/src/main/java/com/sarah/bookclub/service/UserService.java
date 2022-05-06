package com.sarah.bookclub.service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.sarah.bookclub.models.LoginUser;
import com.sarah.bookclub.models.User;
import com.sarah.bookclub.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	// Get all Users
	public List<User> getAllUsers(){
		return repo.findAll();
	}
	
	// Register & Login Methods
	
	public User register(User newUser, BindingResult result) {
		
		// creating instance of potential user
		Optional<User> potentialUser = repo.findByEmail(newUser.getEmail());
		
		// if email is already in database,
		// reject potential user
		if(potentialUser.isPresent()) {
			System.out.println("From UserService: email already in DB");
			result.rejectValue("email", "Matches", "An account with that email already exists!");
		}
		
		// reject if password != confirm
		 if(!newUser.getPassword().equals(newUser.getConfirm())) {
		 System.out.println("From UserService: passwords do not match");
		 result.rejectValue("confirm", "Matches", "Passwords must match"); }
		
		 // if errors in form, return null
		 if(result.hasErrors()) { 
			 System.out.println("errors detected"); 
			 return null;
		 }
		
		// if all checks pass, continue
		
		// hash pw & save to user
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		
		User saveUser = repo.save(newUser);
		System.out.println(saveUser);
		return saveUser;
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		
		Optional<User> potentialUser = repo.findByEmail(newLogin.getEmail());
		
		// find user in the DB by email
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "Email not found");
		}
		
		// User exists, so retrieve user from DB
		User user = potentialUser.get();
		
		// reject if BCrypt password match fails
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password");
		}
		
		// if any errors, return null
		if(result.hasErrors()) {
			return null;
		}
		
		// otherwise, all is good. return user
		return user;
	}
	
	public User findById(Long id) {
		Optional<User> potentialUser = repo.findById(id);
		if (potentialUser.isPresent()) {
			return potentialUser.get();
		}
		System.out.println("From UserService: user not found");
		return null;
	}
}
