package com.example.spring_step_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.spring_step_1.scope.PersonDAO;

@SpringBootApplication
public class SpringStep1BasicScopeApplication {

	// What are the beans?
	// What are the dependencies of a bean?
	// Where to search for beans? => No need
	
	private static Logger LOGGER = LoggerFactory.getLogger(SpringStep1BasicScopeApplication.class);

	public static void main(String[] args) {

		

				// BinarySearchImpl binarySearch =
				// new BinarySearchImpl(new QuickSortAlgorithm());
				// Application Context
				ApplicationContext applicationContext = SpringApplication.run(SpringStep1BasicApplication.class, args);
				PersonDAO personDao1 = applicationContext.getBean(PersonDAO.class);
				PersonDAO personDao2 = applicationContext.getBean(PersonDAO.class);
				LOGGER.info("{}", personDao1);
				LOGGER.info("{}", personDao1.getJdbcConnection());
				
				LOGGER.info("{}", personDao2);
				LOGGER.info("{}", personDao2.getJdbcConnection());
				
	}

}
