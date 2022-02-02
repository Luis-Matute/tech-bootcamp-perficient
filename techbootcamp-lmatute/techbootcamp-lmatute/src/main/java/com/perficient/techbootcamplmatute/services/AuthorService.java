package com.perficient.techbootcamplmatute.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perficient.techbootcamplmatute.entities.AuthorEntity;
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
	
	
	@Autowired
	public void setAuthorRepository(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
}
