package com.spring_boot.example.first_basic.service;

import org.springframework.data.repository.CrudRepository;

import com.spring_boot.example.first_basic.persistence.model.Book;

public interface BookService extends CrudRepository<Book, Long> {

	/*
	 * Spring Boot will create all the queries for a model when you extend the
	 * interface CrudRepository. So all CRUD requests will be available for you at Runtime.
	 * 
#spring.jpa.generate-ddl=true
#spring.jpa.hibernate.ddl-auto=update
	 */
}
