package com.spring_boot.example.book.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Author {

	@Id
	@GeneratedValue
	private String authorName;

	private String authorAddress;

	private Long authorContact;
}
