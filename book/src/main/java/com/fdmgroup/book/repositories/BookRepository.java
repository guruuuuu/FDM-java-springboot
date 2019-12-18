package com.fdmgroup.book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.book.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	public Book findByTitle(String title);
}
