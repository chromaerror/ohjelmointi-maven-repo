package com.example.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + year + ", price=" + price
				+ "]";
	}


	// Id
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	// Variables
	private String title, author, isbn;
	private int year;
	private float price;
	
	// Getters
	public String getTitle() { return title; }
	public String getAuthor() { return author; }
	public String getIsbn() { return isbn; }
	public int getYear() { return year; }
	public float getPrice() { return price; }
	
	// Setters
	public void setTitle(String title) { this.title = title; }
	public void setAuthor(String author) { this.author = author; }
	public void setIsbn(String isbn) { this.isbn = isbn; }
	public void setYear(int year) { this.year = year; }
	public void setPrice(float price) { this.price = price; }

	
	// Constructors
	public Book() {
		this.title = "";
		this.author = "";
		this.isbn = "";
		this.price = 0;
		this.year = 0;
	}
	
	public Book(String title) {
		this.title = title;
		this.author = "";
		this.isbn = "";
		this.price = 0;
		this.year = 0;
	}
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.isbn = "";
		this.price = 0;
		this.year = 0;
	}
	
	public Book(String title, String author, String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = 0;
		this.year = 0;
	}
	
	public Book(String title, String author, String isbn, int year) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.price = 0;
	}
	
	public Book(String title, String author, String isbn, float price) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.year = 0;
	}
	
	
}
