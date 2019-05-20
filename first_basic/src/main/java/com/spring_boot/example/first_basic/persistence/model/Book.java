package com.spring_boot.example.first_basic.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // — used to denote that this class is going to be an Entity in the database.
@Table(name = "books") //-— which takes some values like the name you are going to name your table
/*
 * @Getter
 * 
 * @Setter
 */
public class Book implements Serializable{
	
	private static final long serialVersionUID = 876688928410084519L;

	@Id // — denotes that the id is the primary key / identifying key for this table
	@GeneratedValue
	//(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, unique = true)
	private String title;

	@Column(nullable = false)
	private String author;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
