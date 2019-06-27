package com.microservices.springboot.author.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Author")
@Getter
@Setter
public class Author implements Serializable{

	private static final long serialVersionUID = 876688928410084518L;
	
	@Id
	private Long id;
	
	@Column(nullable = false)
	private String authorName;
	
	@Column
	private String authorAddress;
	
	@Column(nullable = false, unique = true)
	private Long authorContact;
}
