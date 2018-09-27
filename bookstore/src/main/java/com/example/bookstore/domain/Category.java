package com.example.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryid;
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;
	
	public Long getId() { return this.categoryid; }
	public String getName() { return this.name; }
	
	public void setName(String name) { this.name = name; }
	
	public Category() {}
	
	public Category(String name) {
		super();
		this.name = name;
	}
	
}
