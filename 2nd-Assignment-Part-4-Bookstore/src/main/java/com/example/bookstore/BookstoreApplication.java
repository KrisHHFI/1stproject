package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.Category;
import com.example.bookstore.model.CategoryRepository;
import com.example.bookstore.model.User;
import com.example.bookstore.model.UserRepository;

/**
 * This class runs the Book Store Application & initialises a couple books and users. Needs internet connection for Amazon cloud.
 **/

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(CategoryRepository categoryRepository, BookRepository bookRepository, UserRepository urepository) {
		return (args) -> {
			// Category objects created
			System.out.println("save a couple of categories");
			//IMPORTANT- Only save new books the first time you run app. Duplicates cause problems
			//categoryRepository.save(new Category("Action"));
			//categoryRepository.save(new Category("Thought Provoking"));
			// Book objects created
			//IMPORTANT- Only save new books the first time you run app. Duplicates cause problems
			System.out.println("save a couple of books");
			//bookRepository.save(new Book("Cats vs Dogs II", "John James", 1999, "12345678", 9.99, categoryRepository.findByName("Action").get(0)));
			//bookRepository.save(new Book("A man and his penguin", "Alex Agnes", 1998, "22345678", 10.99, categoryRepository.findByName("Thought Provoking").get(0)));
			// Create 2 users (basic user and admin). Attributes: username (unique), password, role, email
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "user@evilcorp.com");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN" , "admin@evilcorp.com");
			//IMPORTANT- Only save new users the first time you run app. Duplicates cause problems
			//urepository.save(user1);
			//urepository.save(user2);
			// Prints all books for testing purposes
			System.out.println("fetch all books");
			for (Book book : bookRepository.findAll()) {
				System.out.println(book.toString());
			}
		};
	}
}