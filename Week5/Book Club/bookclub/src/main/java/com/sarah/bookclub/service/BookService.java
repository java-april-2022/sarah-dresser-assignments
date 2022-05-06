package com.sarah.bookclub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarah.bookclub.models.Book;
import com.sarah.bookclub.models.User;
import com.sarah.bookclub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	
	// Get all Books
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	// Get Books by user(postedBy)
	public List<Book> getByUser(User user){
		return bookRepo.findAllByUser(user);
	}
	
	// Get one book by ID
	public Book getById(Long id) {
		Optional<Book> potentialBook = bookRepo.findById(id);
		if (potentialBook.isPresent()) {
			return potentialBook.get();
		}
		System.out.println("From BookService: book not found");
		return null;
	}
}
