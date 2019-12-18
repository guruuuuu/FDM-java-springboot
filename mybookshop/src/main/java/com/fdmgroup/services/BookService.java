package com.fdmgroup.services;

import java.util.List;

import com.fdmgroup.models.Book;

public interface BookService {
	public Book addBook(Book newBook);

	public void deleteABook(Long id);

	public Book findBookByTitle(String title);
	
	public Iterable<Book> findBooksByTitle(String Title);

	public Iterable<Book> getAllBooks();

	public Book findById(Long id);
}
