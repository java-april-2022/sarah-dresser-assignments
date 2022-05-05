package com.sarah.authentication.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.sarah.authentication.models.User;
import com.sarah.authentication.repositories.UserRepository;

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
			result.rejectValue("email", "Matches", "An account with that email already exists!");
		}
		
		// reject if password != confirm
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "Matches", "Confirm password must match!");
		}
		
		// if errors in form, return null
		if(result.hasErrors()) {
			return null;
		}
		
		// if all checks pass, hash password and 
		// save user to db
		
		// hashed pw
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		// save hashed pw to user
		newUser.setPassword(hashed);
		
		return repo.save(newUser);
	}
}
