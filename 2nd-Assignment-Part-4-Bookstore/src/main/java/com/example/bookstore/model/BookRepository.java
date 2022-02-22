package com.example.bookstore.model;

import org.springframework.data.repository.CrudRepository;

// Hidden methods are imported and utilsied from Crud
public interface BookRepository extends CrudRepository<Book, Long> {
	
}
