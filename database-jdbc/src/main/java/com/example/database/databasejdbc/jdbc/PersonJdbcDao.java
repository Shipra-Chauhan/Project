package com.example.database.databasejdbc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.database.databasejdbc.entity.Person;


/**
 *  The way JDBC works is that we write query first and then map the values to it using parameters.
 *  Also, then we do row mappings.  Mapping with Person bean. 
 *  Disadvantage - Writing query and with large number of tables, queries become complex
 *  Now, that is why JPA is used where object is directly mapped to row in table.
 *  
 *  JPA - take care of identifying entities and creating right queries based on the operations to be performed.
 *  Right shifts from developer to framework in JPA implementation. Hibernate is most popular implementation of JPA.
 *  Hibernate was ORM - Object relational mapping framework. Mapping an object(Person) to a relation(table).
 *  JPA standardizes the ORM and hibernate implements JPA.
 *  
 *  With hibernate, you must have a constructor in entity.( Person())
 *  
 *  
 * */
@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate; //autowired with a datasource connection

	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub

			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getDate("birth_date"));
			return person;
		}
	}

	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
		// To fire this at the start up we implement "CommandLineRunner" in the class
		// where applicationContext instantiates bean
		// BeanPropertyRowMapper - Whenever you use this Mapper, then the bean(Person)
		// used should have no argument constructor.
	}

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id = ?", new Object[] { id });
	}

	public int insert(Person person) {
		return jdbcTemplate.update("insert into person (id, name, location, birth_date) values( ?,?,?,?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(),
						new Timestamp(person.getBirthDate().getTime()) });
	}

	public int update(Person person) {
		return jdbcTemplate.update("update person " + "set name = ?, location = ?, birth_date = ?" + "where id = ?",
				new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()),
						person.getId() });
	}
}
