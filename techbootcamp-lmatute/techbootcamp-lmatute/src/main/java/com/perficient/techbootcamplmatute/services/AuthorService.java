package com.perficient.techbootcamplmatute.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perficient.techbootcamplmatute.entities.AuthorEntity;
import com.perficient.techbootcamplmatute.entities.BlogPostEntity;
import com.perficient.techbootcamplmatute.jpa.AuthorRepository;

@Service
public class AuthorService {
	
	private AuthorRepository authorRepository;
	
	public Iterable<AuthorEntity> getAllAuthors() {
		return authorRepository.findAll();
	}
	
	public AuthorEntity findById(long id) {
		return authorRepository.findById(id);
	}
	
	public AuthorEntity verifyUser(String username) {
		return authorRepository.findByUsername(username);
	}
	
	public void saveAuthor(AuthorEntity author) {
		authorRepository.save(author);
	}
	
	public List<BlogPostEntity> getAuthorsBlogs(long authorId) {
		List<BlogPostEntity> blogPosts = authorRepository.getArticles(authorId);
		
		return blogPosts;
	}
	
	
	@Autowired
	public void setAuthorRepository(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
}
