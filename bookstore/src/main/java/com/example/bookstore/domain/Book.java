package com.example.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Book {
	
	@Override
	public String toString() {
		return "Book [id = " + id + "title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + year + ", price=" + price
				+ "]";
	}


	// Id
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	// Variables
	private String title, author, isbn;
	private int year;
	private double price;
	@ManyToOne
	//@JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;
	
	// Getters
	public Long getId() { return id; }
	public String getTitle() { return title; }
	public String getAuthor() { return author; }
	public String getIsbn() { return isbn; }
	public int getYear() { return year; }
	public double getPrice() { return price; }
	public Category getCategory() { return this.category; }
	//public String getCategoryName() { return this.category.getName(); }
	
	// Setters
	public void setId(Long id) { this.id = id; }
	public void setTitle(String title) { this.title = title; }
	public void setAuthor(String author) { this.author = author; }
	public void setIsbn(String isbn) { this.isbn = isbn; }
	public void setYear(int year) { this.year = year; }
	public void setPrice(double price) { this.price = price; }
	public void setcategory(Category category) { this.category = category; }
	
	// Constructors
	public Book() {
		this.title = "";
		this.author = "";
		this.isbn = "";
	}
	
	public Book(Long id) {
		this.id = id;
	}
	
	public Book(String title) {
		this.title = title;
		this.author = "";
		this.isbn = "";
	}
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.isbn = "";
	}
	
	public Book(String title, String author, String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	
	public Book(String title, String author, String isbn, int year) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
	}
	
	public Book(String title, String author, String isbn, int year, double price) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
	}
	
	public Book(String title, String author, String isbn, int year, double price, Category category) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
		this.category = category;
	}
	
	
}
