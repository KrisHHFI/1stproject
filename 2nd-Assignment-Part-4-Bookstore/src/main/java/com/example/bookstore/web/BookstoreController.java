package com.example.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;

@Controller
public class BookstoreController {
	
	@Autowired
	private BookRepository repository; 
	
	// Returns all the Books to the HTML page
	@RequestMapping(value= {"/", "/booklist"})
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	// Deletes specific books, which are selected from HTML page
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    }    
	
	// Add Book (Part 1)
	@RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        return "addbook";
    }     
	
	// Add Book (Part 2, inputs from addbook.html, then redirected back to booklist.html)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }    
	
	// Edit Book
	@RequestMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model){
		model.addAttribute("book", repository.findById(id));
        return "editbook";
    }   
}
//Browser url: localhost:8080/booklist

// For H2 console
// Url: localhost:8080/h2-console
// JDBC url field= jdbc:h2:mem:testdb