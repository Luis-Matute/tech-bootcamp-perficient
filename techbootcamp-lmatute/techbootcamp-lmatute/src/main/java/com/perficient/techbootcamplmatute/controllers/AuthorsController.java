package com.perficient.techbootcamplmatute.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.techbootcamplmatute.entities.AuthorEntity;
import com.perficient.techbootcamplmatute.jpa.AuthorRepository;
import com.perficient.techbootcamplmatute.services.AuthorService;

@RestController
@CrossOrigin(origins="*")
public class AuthorsController {
	
	private AuthorRepository authorRepository;
	private AuthorService authorService;
	
	@RequestMapping(path="/allAuthors")
	public Iterable<AuthorEntity> getAllAuthors() {
		return authorService.getAllAuthors();
	}
	
	@RequestMapping(path="/findAuthorById")
	public @ResponseBody AuthorEntity getAuthorById(@RequestParam long id) {
		return authorRepository.findById(id);
	}
	
//	@PostMapping(path="/createAuthor")
//	public @ResponseBody void createAuthor() {
//		
//	}
	
	@Autowired
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@Autowired
	public void setAuthorRepository(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
}
