package com.example.Bookstore.Web.2nd_Assignment_Part4_Bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//to view had to type- http://localhost:8080/ into the browser
// To see extensions add at end e.g= http://localhost:8080/contact
/*Chapter 1
	1. Controller and endpoints ------------------------------- */

@Controller
@ResponseBody
public class Book {
	//Attributes
	private String title;
	private String Author;
	private Int Year;
	private String ISBN;
	private Double Price;
	
	
	// @RequestMapping("*")
	@RequestMapping("/bookstore")
	public String index() {
		return "This is the Book Store";
	}

}
