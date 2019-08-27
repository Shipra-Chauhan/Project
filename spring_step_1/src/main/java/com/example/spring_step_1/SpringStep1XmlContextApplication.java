package com.example.spring_step_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.spring_step_1.basics.BinarySearchImpl;
import com.example.spring_step_1.scope.XmlPersonDAO;

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
public class SpringStep1XmlContextApplication {


	private static Logger LOGGER = LoggerFactory.getLogger(SpringStep1XmlContextApplication.class);
	
	public static void main(String[] args) {
		
		// BinarySearchImpl binarySearch =
		// new BinarySearchImpl(new QuickSortAlgorithm());
		// Application Context
		try(ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml")){  // To use it when Spring boot is not used
				//SpringApplication.run(SpringStep1BasicScopeApplication.class, args);  // To use it when Spring boot is used.
		XmlPersonDAO xmlPersonDAO = 
				applicationContext.getBean(XmlPersonDAO.class);
		System.out.println(xmlPersonDAO);
		System.out.println(xmlPersonDAO.getXmlJdbcConnection());
		LOGGER.info("Beans Loaded - > {}", 
				(Object)applicationContext.getBeanDefinitionNames());
		//Beans Loaded - > [xmlJdbcConnection, xmlPersonDAO]
		
		/* 				or    
		 * applicationContext.getBeanDefinitionNames());
		 * //Beans Loaded - > [xmlJdbcConnection]
		 * */
		
				}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
