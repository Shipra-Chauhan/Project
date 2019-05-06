package com.example.spring_step_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.spring_step_1.basics.BinarySearchImpl;

@SpringBootApplication
public class SpringStep1BasicApplication {

	// What are the beans?
	// What are the dependencies of a bean?
	// Where to search for beans? => No need

	public static void main(String[] args) {
		
		// BinarySearchImpl binarySearch =
		// new BinarySearchImpl(new QuickSortAlgorithm());
		// Application Context
		ApplicationContext applicationContext = 
				SpringApplication.run(SpringStep1BasicScopeApplication.class, args);
		BinarySearchImpl binarySearch = 
				applicationContext.getBean(BinarySearchImpl.class);
		BinarySearchImpl binarySearch1 = 
				applicationContext.getBean(BinarySearchImpl.class);
		System.out.println(binarySearch);
		System.out.println(binarySearch1);
		int result = 
				binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);
		System.out.println(result);
	}

}
