package com.example.bookstore.web;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

//import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;

@Controller
//@ResponseBody
public class BookstoreController {
	
	@Autowired
	private BookRepository repository; 
	
	@RequestMapping(value= {"/", "/booklist"})
	public String bookList(Model model) {
	
		//List<Book> books = repository.findById();
		model.addAttribute("books", repository.findAll());
		
		return "booklist";
	}
}


// Browser url: localhost:8080/h2-console
//Browser url: localhost:8080/booklist
// JDBC url field= jdbc:h2:mem:testdb