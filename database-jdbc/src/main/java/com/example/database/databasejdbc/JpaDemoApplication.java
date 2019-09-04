package com.example.database.databasejdbc;



import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.database.databasejdbc.entity.Person;
import com.example.database.databasejdbc.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
	
	// CommandLineRunner - It runs the JdbcTemplate queries as soon as
	// ApplicationContext is ready.

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("All users 10001 ->  {}",repository.findById(10001));
		logger.info("Inserting user 10004 ->  {}", repository.insert(new Person("Aayushi", "Gurgaon", new Date())));
		logger.info("Updating user 10003 ->  {}", repository.update(new Person(10003, "Pieter", "Belgium", new Date())));
		/*
		logger.info("All users -> {}",dao.findAll());
		
		logger.info("Delete user 10002 -> , No of rows deleted - {}",repository.deleteById(10002));
		*/
		//(10003,  'Pieter', 'Amsterdam',sysdate())
	}

}
