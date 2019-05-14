package com.example.spring_step_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.spring_step_1.basics.BinarySearchImpl;

/*
 * When spring boot is not used then we have to do the following things manually as there are lot of 
 * things that spring boot does by default
 * 1. Use @Configuration instead of @SpringBootApplication to define configuration
 * 2. Use AnnotationConfigApplicationContext insteadof SpringApplication.run (Line 34) to get application context
 * 3. Use @ComponentScan
 * 4. Define slf4j dependency in pom.xml explicitly
 * */

@Configuration // Used to define configuration when spring is used.
@ComponentScan  // To use when spring boot is not used as spring boot by default does component scan
//@SpringBootApplication
public class SpringStep1BasicApplication {

	// What are the beans?
	// What are the dependencies of a bean?
	// Where to search for beans? => No need

	public static void main(String[] args) {
		
		// BinarySearchImpl binarySearch =
		// new BinarySearchImpl(new QuickSortAlgorithm());
		// Application Context
		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(SpringStep1BasicApplication.class);  // To use it when Spring boot is not used
				//SpringApplication.run(SpringStep1BasicScopeApplication.class, args);  // To use it when Spring boot is used.
		BinarySearchImpl binarySearch = 
				applicationContext.getBean(BinarySearchImpl.class);
		BinarySearchImpl binarySearch1 = 
				applicationContext.getBean(BinarySearchImpl.class);
		System.out.println(binarySearch);
		System.out.println(binarySearch1);
		int result = 
				binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);
		System.out.println(result);
		
		// To close application context, define applicationContext of type - AnnotationConfigApplicationContext instead of ApplicationContext
		//AnnotationConfigApplicationContext - implements Autocloseable interface so can be used with try with ARM 
		AnnotationConfigApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(SpringStep1BasicApplication.class);
		applicationContext2.close();
	}

}
