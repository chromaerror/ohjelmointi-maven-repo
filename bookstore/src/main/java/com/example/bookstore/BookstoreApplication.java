package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository catrep) {
		return(args) -> {
			
			catrep.save(new Category("IT"));
			catrep.save(new Category("Drama"));
			catrep.save(new Category("Action"));
			
			repository.save(new Book("A Farewell to Arms", "Ernest Hemingway", "1233321-12", 1929, 0.0, catrep.findByName("IT").get(0)));
			repository.save(new Book("Harry Potter", "J.K Rowling", "1234124-123", 1997, 0.0, catrep.findByName("IT").get(0)));
			repository.save(new Book("Animal Farm", "George Orwell", "221231-213", 1945, 0.0, catrep.findByName("Action").get(0)));
			System.out.println("Books found with findAll:");
			for(Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
			System.out.println("Books found with findByTitle:");
			for(Book book : repository.findByTitle("Moby Dick")) {
				log.info(book.toString());
			}
		};
	}
	
}
