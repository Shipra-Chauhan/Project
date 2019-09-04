package com.example.database.databasejdbc.jpa;

/**
 * In data.sql remove create table command as in Spring jdbc, you have to write query and create table. But spring boot itself picks and uses schemaupdate and create person table as 
 * soon as it finds @Entity annotation. Schemaupdate is triggered by springboot autoconfiguration and it is one of the features i hibernate. So, when we use embedded database, schema 
 * is created auto by spring boot.
 * **/

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.database.databasejdbc.entity.Person;

//Repository
@Repository
//Transaction Management -In a single transaction either all of operations are passed or all of them fails.
@Transactional
public class PersonJpaRepository {

//connect to database
	@PersistenceContext // All operations to be performed are stored here and entity manager is the
						// interface to this.
	EntityManager entityManager; // manages entities. All operations have to be going through EM.

	public Person findById(int id) {
		return entityManager.find(Person.class, id); // JPA
	}

	public Person update(Person	person) {
		return entityManager.merge(person);
	}
	
	public Person insert(Person	person) {
		return entityManager.merge(person);
	}
	
}
