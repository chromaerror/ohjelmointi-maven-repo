package com.example.bookstore.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@Controller
public class BookController {
	// NEW COMMIT
	private static final Logger log = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String hello(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return 	"redirect:index";
	}
	
	@RequestMapping(value = "/save/{id}", method = RequestMethod.POST)
	public String saveEdit(@PathVariable("id") Long bookId, Book book) {
		book.setId(bookId);
		repository.save(book);
		return "redirect:../index";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../index";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		Book book = new Book();
		book.setId(bookId);
		log.info(book.toString());
		model.addAttribute("book", book);
		return "editbook";
		
	}

}
