package com.sarah.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sarah.bookclub.models.Book;
import com.sarah.bookclub.models.User;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findAll();
	List<Book> findAllByUser(User user);
}
