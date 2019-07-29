package com.microservices.springboot.author.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.springboot.author.entity.Author;
import com.microservices.springboot.author.repository.AuthorRepository;

@RestController
public class AuthorController {

	@Autowired
	private Environment environment;

	@Autowired
	private AuthorRepository authorRepository;

	// @Autowired private AuthorServiceProxy proxy;

	@GetMapping("/author/{name}")
	public Author retrieveAuthorDetails(@PathVariable String name) {

		 Author author = 
				 //proxy.retrieveAuthorDetails(name);
		authorRepository.findByAuthorName(name);
		author.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

		return author;
	}

}
