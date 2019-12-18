package com.fdmgroup.book.models;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "Books")
public class Book {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	private UUID bookId= UUID.randomUUID();
	@NotBlank(message = "Name is Required")
	@Size(min = 2, max = 100, message = "Please make sure name is between 2 to 100 characters")
	private String title;
	private String author;
	private double price;
	
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
	public Book() {
		
	}

	public Book(String title, String author, double price) {
		this.bookId = getBookId();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getBookId() {
		return bookId;
	}

	public void setBookId(UUID bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
	public void createdAt() {
		this.createdAt = LocalDate.now();
	}
	
	@PreUpdate
	public void updateAt() {
		this.updatedAt = LocalDate.now();
	}
	
	
}
