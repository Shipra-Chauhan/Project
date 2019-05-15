package com.spring_boot.example.first_basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring_boot.example.first_basic.exception.BookIdMismatchException;
import com.spring_boot.example.first_basic.exception.BookMismatchException;
import com.spring_boot.example.first_basic.exception.BookNotFoundException;
import com.spring_boot.example.first_basic.persistence.model.Book;
import com.spring_boot.example.first_basic.persistence.repository.BookRepository;

public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	public Iterable<Book> findAll() {
		return bookRepository.findAll();
	}
	
	@GetMapping("/title/{bookTitle}")
	public List<Book> findByTitle(@PathVariable String bookTitle) {
		return bookRepository.findByTitle(bookTitle);
	}

	@GetMapping("/{id}")
	public Book findOne(@PathVariable Long id) throws BookNotFoundException {
		return bookRepository.findById(id)
				.orElseThrow(BookNotFoundException :: new);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Book create(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	@DeleteMapping("/{id}")
	public void deleted(@PathVariable Long id) throws BookNotFoundException {
		bookRepository.findById(id)
		.orElseThrow(BookNotFoundException::new);
		bookRepository.deleteById(id);
		
	}
	
	@PutMapping("/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable Long id) throws BookIdMismatchException, BookNotFoundException {
		if(book.getId() != id) {
			throw new BookIdMismatchException();
		}
		
		bookRepository.findById(id)
		.orElseThrow(BookNotFoundException::new);
		return bookRepository.save(book);
	}
	
	
}
