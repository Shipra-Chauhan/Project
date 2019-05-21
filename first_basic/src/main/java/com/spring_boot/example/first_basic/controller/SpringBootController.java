package com.spring_boot.example.first_basic.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot.example.first_basic.persistence.model.Book;

@Controller
public class SpringBootController {

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
	public String bookSubmit(@ModelAttribute Book book) {
		return "result";
	}

}
