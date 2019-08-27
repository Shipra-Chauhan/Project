//The package is not a part of component scan path
package com.example.spring_step_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.spring_step_1.componentscan.ComponentDAO;

@SpringBootApplication
@ComponentScan("com.spring_step_1")
public class SpringStep1BasicComponentScanApplication {

	// What are the beans?
	// What are the dependencies of a bean?
	// Where to search for beans? => No need
	
	private static Logger LOGGER = LoggerFactory.getLogger(SpringStep1BasicComponentScanApplication.class);

	public static void main(String[] args) {

				// BinarySearchImpl binarySearch =
				// new BinarySearchImpl(new QuickSortAlgorithm());
				// Application Context
				ApplicationContext applicationContext = SpringApplication.run(SpringStep1BasicComponentScanApplication.class, args);
				ComponentDAO compDAO = applicationContext.getBean(ComponentDAO.class);
				LOGGER.info("{}", compDAO);
				LOGGER.info("{}", compDAO.getJdbcConnection());
				
	}

}
