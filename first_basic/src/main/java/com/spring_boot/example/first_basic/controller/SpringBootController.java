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

@Controller
//@RestController

/*A Spring @Bean that is marked as @RefreshScope will get special treatment when there is a configuration change.
This addresses the problem of stateful beans that only get their configuration injected when they are initialized.
For instance if a DataSource has open connections when the database URL is changed via the Environment,
we probably want the holders of those connections to be able to complete what they are doing. 
Then the next time someone borrows a connection from the pool he gets one with the new URL.
Refresh scope beans are lazy proxies that initialize when they are used (i.e. when a method is called),
 and the scope acts as a cache of initialized values. To force a bean to re-initialize on the next method call you just need to invalidate its cache entry.
 */
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
