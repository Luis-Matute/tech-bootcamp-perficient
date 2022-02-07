package com.perficient.techbootcamplmatute.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.techbootcamplmatute.entities.AuthorEntity;
import com.perficient.techbootcamplmatute.entities.BlogPostEntity;
import com.perficient.techbootcamplmatute.services.AuthorService;

@RestController
@CrossOrigin(origins="*")
public class AuthorsController {
	
	private AuthorService authorService;
	
	@RequestMapping(path="/allAuthors")
	public Iterable<AuthorEntity> getAllAuthors() {
		return authorService.getAllAuthors();
	}
	
	@RequestMapping(path="/findAuthorById")
	public @ResponseBody AuthorEntity getAuthorById(@RequestParam long id) {
		return authorService.findById(id);
	}
	
	@PostMapping(path="/createAuthor")
	public @ResponseBody void createAuthor(@RequestBody AuthorEntity authorEntity) {
		System.out.println(authorEntity);
		authorService.saveAuthor(authorEntity);
	}
	
	@RequestMapping(path="/confirmUser")
	public AuthorEntity verifyUser(@RequestBody AuthorEntity authorEntity) {
		// AuthorEntity author = authorRepository.findByUsername(authorEntity.getUsername());
		return authorService.verifyUser(authorEntity.getUsername());
	}
	
	@RequestMapping(path="/getAuthorBlogs")
	public List<BlogPostEntity> getAuthorBlogs(@RequestParam long id) {
		return authorService.getAuthorsBlogs(id);
	}
	
	@Autowired
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}
	
}
