package com.microservices.springboot.author.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.springboot.author.model.Author;


public interface AuthorRepository extends JpaRepository<Author, Long>{

	List<Author> findByAuthorName(String name);
}
