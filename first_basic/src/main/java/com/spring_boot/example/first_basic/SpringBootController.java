package com.spring_boot.example.first_basic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class SpringBootController {

@Value("${spring.application.name}")
String appName;

@GetMapping("/")
public String homePage(Model model) {
	 model.addAttribute("appName", appName);
     return "home";
}

}
