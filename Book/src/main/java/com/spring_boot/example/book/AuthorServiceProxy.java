/**
 * 
 */
package com.spring_boot.example.book;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring_boot.example.book.persistence.model.Book;

/**
 * @author shchauhan
 *
 */

@FeignClient(name= "Author-Service", url = "localhost:8080")
public interface AuthorServiceProxy {
	
	@GetMapping("/author/{name}")
	public Book retrieveAuthorDetails(@PathVariable String name);

}
