package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.Category;
import com.example.bookstore.model.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(CategoryRepository categoryRepository, BookRepository bookRepository) {
		return (args) -> {
			// Category objects created
			System.out.println("save a couple of categories");
			categoryRepository.save(new Category("Action"));
			categoryRepository.save(new Category("Thought Provoking"));
			// Book objects created
			System.out.println("save a couple of books");
			bookRepository.save(new Book("Cats vs Dogs II", "John James", 1999, "12345678", 9.99, categoryRepository.findByName("Action").get(0)));
			bookRepository.save(new Book("A man and his penguin", "Alex Agnes", 1998, "22345678", 10.99, categoryRepository.findByName("Thought Provoking").get(0)));
			
			System.out.println("fetch all books");
			for (Book book : bookRepository.findAll()) {
				System.out.println(book.toString());
			}
		};
	}
}