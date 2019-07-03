package com.microservices.springboot.author.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Author {

	@Id
	@GeneratedValue
	private Long id;

	private String authorName;

	private String authorAddress;

	private Long authorContact;

	private int port;
}
