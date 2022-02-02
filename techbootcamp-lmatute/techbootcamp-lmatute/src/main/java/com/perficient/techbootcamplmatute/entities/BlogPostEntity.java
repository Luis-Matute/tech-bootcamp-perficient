package com.perficient.techbootcamplmatute.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// You can use the name on entity later for HQL queries.
@Entity(name="blog_post")
@Table(name = "blog_posts")
public class BlogPostEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column
	private String title;
	
	@Column
	private String content;
	
	@ManyToOne
	@JoinColumn(name="author_id", nullable=false)
	private AuthorEntity author;
	
	public BlogPostEntity() {}
	
	public BlogPostEntity(String title, String content) {
		this.title = title;
		this.content = content;
	}

	
	
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public AuthorEntity getAuthor() {
		return author;
	}

	public void setAuthor(AuthorEntity author) {
		this.author = author;
	}
	
}
