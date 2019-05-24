package com.spring_boot.example.first_basic.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; // JPA repository H2
import org.springframework.data.repository.CrudRepository; //Hibernate
import org.springframework.stereotype.Repository;

import com.spring_boot.example.first_basic.persistence.model.Book;

@Repository // - Annotation used to Indicate the DAO (Data Access Object) component in the persistence layer. 
//It tells the compiler that the interface is going to use the Repository to do database activities.
public interface BookRepository extends 
//JpaRepository<Book, Long>

CrudRepository<Book, Long>
{

	List<Book> findByTitle(String title);
}
