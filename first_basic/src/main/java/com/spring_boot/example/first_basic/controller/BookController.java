package com.spring_boot.example.first_basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot.example.first_basic.exception.BookIdMismatchException;
import com.spring_boot.example.first_basic.exception.BookNotFoundException;
import com.spring_boot.example.first_basic.persistence.model.Book;
import com.spring_boot.example.first_basic.persistence.repository.BookRepository;

//https://s3.amazonaws.com/baeldung.com/A+Microservice+Architecture+with+Spring+Boot+and+Spring+Cloud.pdf?__s=idyx7yr318sdjnqo6j7r

//https://spring.io/guides/gs/handling-form-submission/
@RestController
@RequestMapping("/books") // - after URl this must be present and then further the ath must be appended
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
		
		/*
		 * orElseThrow(): This is a method found in the Optional class in Java8 which
		 * was introduced to handle Exceptions. The optional class provides various
		 * utility methods to check the presence or absence of an object, which helps to
		 * deal with NullPointerException. orElseThrow is a method that Returns value if
		 * present, otherwise invokes an exception.
		 */
	}
	
	@GetMapping("/")
	public Book get() {
		return bookRepository.findById(1L)
				.orElseThrow(RuntimeException :: new);
	}
	
	
	@PostMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Book create(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleted(@PathVariable Long id) throws BookNotFoundException {
		bookRepository.findById(id)
		.orElseThrow(BookNotFoundException::new);
		bookRepository.deleteById(id);
		return ResponseEntity.ok().build();
		
		/* ResponseEntity -
		 * It’s a Java class which inherits HttpEntity class to manipulate the HTTP
		 * Responses. Whether the request of the connection is “OK” or if there are any
		 * problems, throw an exception from the HttpEntity class.
		 */
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
