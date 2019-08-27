package com.example.spring_step_1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.spring_step_1.properties.SomeExternalService;


@Configuration // Used to define configuration when spring is used.
@ComponentScan  // To use when spring boot is not used as spring boot by default does component scan
@PropertySource("classpath:app.properties")
public class SpringStep1PropertiesApplication {

	public static void main(String[] args) {
		
		try(AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(SpringStep1PropertiesApplication.class)){
				// To use it when Spring boot is not used
		SomeExternalService service = 
				applicationContext.getBean(SomeExternalService.class);
		System.out.println(service.getUrl());
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
