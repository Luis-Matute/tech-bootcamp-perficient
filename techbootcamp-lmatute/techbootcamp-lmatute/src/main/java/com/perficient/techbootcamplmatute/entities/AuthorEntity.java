package com.perficient.techbootcamplmatute.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "authors")
public class AuthorEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy="author")
	//@JsonManagedReference
	@JsonIgnoreProperties("author")
	private Set<BlogPostEntity> blogPosts;
	
	public AuthorEntity() {}

	public AuthorEntity(String username, String description) {
		this.username = username;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<BlogPostEntity> getBlogPosts() {
		return blogPosts;
	}

	public void setBlogPosts(Set<BlogPostEntity> blogPosts) {
		this.blogPosts = blogPosts;
	}
	
	
}
