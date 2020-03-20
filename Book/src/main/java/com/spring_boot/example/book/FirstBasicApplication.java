package com.spring_boot.example.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan
@EnableJpaRepositories("com.spring_boot.example.book.persistence.repository") // to scan the specified package for repositories
@EntityScan("com.spring_boot.example.book.persistence.model") // to pick up our JPA entities
@SpringBootApplication
@EnableFeignClients("com.microservices.springboot.author")
@EnableDiscoveryClient //try to contact a Consul agent 
@Configuration
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
