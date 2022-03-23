package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.CategoryRepository;

import org.junit.jupiter.api.Test;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookRepositoryTest {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	// Searches for a specific book title and then the matching author
	@Test
	public void findByTitleAndReturnAuthor() {
		List<Book> books = bookRepository.findByTitle("Cats vs Dogs II");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("John James");
	}

	// Creates a book
	@Test
    public void createNewBook() {
    	Book book = new Book("Test Title", "Test Author", 1111, "111111111", 1.11, categoryRepository.findByName("Action").get(0));
    	bookRepository.save(book);
    	assertThat(book.getId()).isNotNull();
    	// Deletes the test book after testing
    	bookRepository.delete(book);
    } 
}
