package com.fdmgroup.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.book.models.Book;
import com.fdmgroup.book.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public Book addBook(Book newBook) {
		return this.bookRepository.save(newBook);
	}

	public List<Book> getAllBooks() {
		return this.bookRepository.findAll();
	}

	public Book getBookByTitle(String title) {
		return this.bookRepository.findByTitle(title);
	}

	public void deleteBook(String title) {

		Book foundBook = this.bookRepository.findByTitle(title);
		this.bookRepository.delete(foundBook);

	}
}
