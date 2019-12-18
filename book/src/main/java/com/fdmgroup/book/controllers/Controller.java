package com.fdmgroup.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.book.models.Book;
import com.fdmgroup.book.services.BookService;



@RestController
public class Controller {

	@Autowired
	BookService bookService;
	
	@PostMapping("/api/books")
	public ResponseEntity<Book> registerBook(@RequestBody Book book) {
		
		Book createdBook = this.bookService.addBook(book);
		return new ResponseEntity<Book>(createdBook, HttpStatus.CREATED);
	}
	
	@GetMapping("/api/books")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> allBooks = this.bookService.getAllBooks();
		return new ResponseEntity<List<Book>>(allBooks, HttpStatus.OK);
	}
	
	@DeleteMapping("/api/books/{title}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable String title){
		this.bookService.deleteBook(title);
		return new ResponseEntity(HttpStatus.GONE);
	}
}
