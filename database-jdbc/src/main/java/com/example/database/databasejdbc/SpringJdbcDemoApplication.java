package com.example.database.databasejdbc;



import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.database.databasejdbc.entity.Person;
import com.example.database.databasejdbc.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {
	
	// CommandLineRunner - It runs the JdbcTemplate queries as soon as
	// ApplicationContext is ready.

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("All users -> {}",dao.findAll());
		logger.info("All users 10001 ->  {}",dao.findById(10001));
		logger.info("Delete user 10002 -> , No of rows deleted - {}",dao.deleteById(10002));
		logger.info("Inserting user 10004 ->  {}", dao.insert(new Person(10004, "Aayushi", "Gurgaon", new Date())));
		logger.info("Updating user 10003 ->  {}", dao.update(new Person(10003, "Pieter", "Belgium", new Date())));
		//(10003,  'Pieter', 'Amsterdam',sysdate())
	}

}
