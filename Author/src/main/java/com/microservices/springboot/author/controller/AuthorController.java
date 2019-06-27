package com.microservices.springboot.author.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.springboot.author.repository.AuthorRepository;

@RestController
public class AuthorController {

@Autowired
private Environment environment;

@Autowired
private AuthorRepository authorRepositry;
}
