package com.spring_boot.example.first_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring_boot.example.first_basic.persistence.model.Book;

//@Controller
@RestController
@RefreshScope
public class SpringBootController {
	
	@Autowired
	BookController b;

	@Value("${spring.application.name}")
	String appName;

	@GetMapping("/")
	public String homePage(Model model) {
		System.out.println("My app : " + appName);
		model.addAttribute("appName", appName);
		return "home";
	}

	@GetMapping("/books")
	public String bookForm(Model model) {
		model.addAttribute("books", new Book());
		return "books";
	}

	@PostMapping("/books")
	public ModelAndView bookSubmit(@ModelAttribute Book book) { //ModelAndView returns View and here, b.create(book) returns "result" which in turn will be used as html(view) and not text/json.
		ModelAndView mav = new ModelAndView();   
		mav.addObject(b.create(book));
		return mav;
	}
	

}
