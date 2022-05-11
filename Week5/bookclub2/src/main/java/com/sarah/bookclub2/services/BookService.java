package com.sarah.bookclub2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarah.bookclub2.models.Book;
import com.sarah.bookclub2.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;

	// Get one book by ID
	public Book getById(Long id) {
		return bookRepo.findById(id).get();
	}
	
	// Get all books
	public List<Book> getAll(){
		return bookRepo.findAll();
	}
	
	// Save book
	public void save(Book book) {
		bookRepo.save(book);
	}
}
