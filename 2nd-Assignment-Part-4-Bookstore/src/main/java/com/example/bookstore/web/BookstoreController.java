package com.example.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class BookstoreController {
	//Attributes
	private String title;
	private String Author;
	private int Year;
	private String ISBN;
	private Double Price;
	
	@RequestMapping("*")
	//@RequestMapping("/bookstore")
	public String index() {
		return "This is the Book Store";
	}
}
