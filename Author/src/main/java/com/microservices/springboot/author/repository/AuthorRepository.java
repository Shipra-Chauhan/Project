package com.microservices.springboot.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.springboot.author.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	Author findByAuthorName(String name);
}
