package com.example.bookstore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// Hidden methods are imported and utilised from Crud
public interface CategoryRepository extends CrudRepository<Category, Long> {
	 List<Category> findByName(String name);
}