package com.spring_boot.example.first_basic.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
