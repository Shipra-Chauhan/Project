package com.example.spring_step_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.spring_step_1.basics.BinarySearchImpl;
import com.example.spring_step_1.cdi.CDIBusiness;
import com.example.spring_step_1.cdi.CDI_Dao;
import com.example.spring_step_1.scope.PersonDAO;

@SpringBootApplication
public class SpringStep1CDIApplication {

	// What are the beans?
	// What are the dependencies of a bean?
	// Where to search for beans? => No need

	private static Logger LOGGER = LoggerFactory.getLogger(SpringStep1BasicScopeApplication.class);
	
	public static void main(String[] args) {
		
		// BinarySearchImpl binarySearch =
		// new BinarySearchImpl(new QuickSortAlgorithm());
		// Application Context
		ApplicationContext applicationContext = SpringApplication.run(SpringStep1CDIApplication.class, args);
		CDIBusiness cdiBusiness = applicationContext.getBean(CDIBusiness.class);
		LOGGER.info("{} , dao --{}", cdiBusiness, cdiBusiness.getCdiDao());
	}

}
