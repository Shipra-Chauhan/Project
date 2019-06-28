package com.spring_boot.example.first_basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan
//@EnableDiscoveryClient //try to contact a Consul agent 
//@EnableJpaRepositories- to scan the specified package for repositories
//@EntityScan- to pick up our JPA entities
@EnableJpaRepositories("com.spring_boot.example.first_basic.persistence.repository")
@EntityScan("com.spring_boot.example.first_basic.persistence.model")
@SpringBootApplication(scanBasePackages = "com.spring_boot")

public class FirstBasicApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(FirstBasicApplication.class, args);
		//new SpringApplicationBuilder(FirstBasicApplication.class).web(WebApplicationType.NONE).run(args);
	}

	/*@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}*/
}
