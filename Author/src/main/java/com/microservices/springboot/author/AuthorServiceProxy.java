/**
 * 
 */
package com.microservices.springboot.author;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.springboot.author.entity.Author;

/**
 * @author shchauhan
 *
 */

@FeignClient(name= "Shipra", url = "localhost:8080")
public interface AuthorServiceProxy {
	
	@GetMapping("/author/{name}")
	public Author retrieveAuthorDetails(@PathVariable String name);

}
