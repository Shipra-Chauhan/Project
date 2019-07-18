package com.spring_boot.example.first_basic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

import com.spring_boot.example.first_basic.exception.BookIdMismatchException;
import com.spring_boot.example.first_basic.exception.BookNotFoundException;
import com.spring_boot.example.first_basic.persistence.model.Author;
import com.spring_boot.example.first_basic.persistence.model.Book;
import com.spring_boot.example.first_basic.persistence.repository.BookRepository;

//https://s3.amazonaws.com/baeldung.com/A+Microservice+Architecture+with+Spring+Boot+and+Spring+Cloud.pdf?__s=idyx7yr318sdjnqo6j7r

//https://spring.io/guides/gs/handling-form-submission/


/*The controller annotated with @Controller annotation in Spring MVC (Model-View-Controller) incorporates the business logic and controls the data flow between the model and view.
The controller methods in most cases return ModelAndView object in order to render the view. But sometimes the value returned from controller methods is displayed to users in the format
of JSON/XML instead of HTML page. To make this happen, annotation @ResponseBody comes into play and automatically serialize the returned value into JSON/XML which later is saved into the 
HTTP response body.The annotation @RestController combines the proceeding annotations and offers more convenience to create RESTful controllers.*/


@Controller
//@RestController // - Combine @Controller and @ResponseBody annotations
@RequestMapping("/books") // - after URl this must be present and then further the path must be appended
public class BookController {

	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/")
	public Iterable<Book> findAll() {
		return bookRepository.findAll();
	}

	@GetMapping("/title/{bookTitle}")
	@ResponseBody
	public List<Book> findByTitle(@PathVariable String bookTitle) {
		return bookRepository.findByTitle(bookTitle);
	}

	@GetMapping("/{id}")
	public Book findOne(@PathVariable Long id) throws BookNotFoundException {
		System.out.println("My book id : " + id);
		return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);

		/*
		 * orElseThrow(): This is a method found in the Optional class in Java8 which
		 * was introduced to handle Exceptions. The optional class provides various
		 * utility methods to check the presence or absence of an object, which helps to
		 * deal with NullPointerException. orElseThrow is a method that Returns value if
		 * present, otherwise invokes an exception.
		 */
	}

//	@GetMapping("/")
//	public String get( Model model) {
//		model.addAttribute("books", new Book());
//		return "books"; //returned as a string response when restcontroller is used and as an view(like.html) when controller is used.
//		
//		//return bookRepository.findById(1L).orElseThrow(RuntimeException::new);
//	}
	
	@GetMapping("/author/{name}")
	//@ResponseBody
	  public Author getAuthorDetails(@PathVariable String name) {

	    Map<String, String> uriVariables = new HashMap<>();
	    uriVariables.put("name", name);

	    ResponseEntity<Author> responseEntity = new RestTemplate().getForEntity(
	        "http://localhost:8080/author/{name}", Author.class,
	        uriVariables);

	    Author response = responseEntity.getBody();

	    return response;
	  }

	@PostMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody @ModelAttribute Book book) {
		System.out.println("My book id : "+book.getId());
		bookRepository.save(book);
		return "result";
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleted(@PathVariable Long id) throws BookNotFoundException {
		bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
		bookRepository.deleteById(id);
		return ResponseEntity.ok().build();

		/*
		 * ResponseEntity - It’s a Java class which inherits HttpEntity class to
		 * manipulate the HTTP Responses. Whether the request of the connection is “OK”
		 * or if there are any problems, throw an exception from the HttpEntity class.
		 */
	}

	@PutMapping("/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable Long id)
			throws BookIdMismatchException, BookNotFoundException {
		if (book.getId() != id) {
			throw new BookIdMismatchException();
		}

		bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
		return bookRepository.save(book);
	}

}



  
