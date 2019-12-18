package com.fdmgroup.controllers;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.models.Author;
import com.fdmgroup.models.Book;
import com.fdmgroup.services.AuthorService;

@Controller
@Transactional
public class AuthorController {

	private AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@GetMapping("/add-author")
	public String addAuthor() {
		return "add-author";
	}

	@PostMapping("/add-author")
	public String addAuthor(@RequestParam String name, @RequestParam String email, @RequestParam String phone,
			ModelMap map) {
		Author author = new Author(name, email, phone);
		this.authorService.addAuthor(author);
		Iterable<Author> authors = this.authorService.getAllAuthors();
		map.addAttribute("authors", authors);
		return "all-authors";
	}

	@GetMapping("/all-authors")
	public String getAllAuthors(ModelMap map) {
		Iterable<Author> authors = this.authorService.getAllAuthors();
		map.addAttribute("authors", authors);
		return "all-authors";
	}

	@GetMapping("/deleteauthor")
	public String deleteAuthor(@RequestParam String email, ModelMap map) {
		System.out.println(email);
		this.authorService.deleteAuthor(email);
		Iterable<Author> result = this.authorService.getAllAuthors();
		map.addAttribute("authors", result);
		return "all-authors";
	}
	
	@GetMapping("/editauthor")
	public String updateBook(@RequestParam String email, ModelMap map) {
		Author foundAuthor = this.authorService.findAuthorByEmail(email);
		map.addAttribute("author", foundAuthor);
		return "edit-author";
	}

	@PostMapping("/editauthor")
	public String updateAuthor(@RequestParam Long id, @RequestParam String email, @RequestParam String name, @RequestParam String phone,
			 ModelMap map) {
		Author author = new Author(name, email, phone);
		System.out.println(id);
		author.setId(id);
		this.authorService.addAuthor(author);
		Iterable<Author> authors = this.authorService.getAllAuthors();
		map.addAttribute("authors", authors);
		return "all-authors";
	}
	
	@GetMapping("/searchauthor")
	public String searchBook(@RequestParam String email, ModelMap map) {
		Iterable<Author> authors = this.authorService.getAllAuthorsByEmail(email);
		map.addAttribute("authors", authors);
		return "searchauthor";
	}
}
