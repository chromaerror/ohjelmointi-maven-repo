package com.example.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bookstore.domain.Book;

@Controller
@ResponseBody
public class BookController {
	@RequestMapping("/index")
	public String hello(Model model, Book book) {
		book = new Book();
		return book.toString();
	}
}
