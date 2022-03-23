package com.example.bookstore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// Hidden methods are imported and utilised from Crud
public interface BookRepository extends CrudRepository<Book, Long> {
	
	List<Book> findByTitle(String title);
	
}
