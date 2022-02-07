package com.perficient.techbootcamplmatute.controllers;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.techbootcamplmatute.entities.AuthorEntity;
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
//		// Hashing password when creating a new author
//		int strength = 10;
//
//		BCryptPasswordEncoder bCryptPasswordEncoder =
//				  new BCryptPasswordEncoder(strength, new SecureRandom());
//		String encodedPassword = bCryptPasswordEncoder.encode(authorEntity.PasswordInternal());
//				 
//		
		authorService.saveAuthor(authorEntity);
	}
	
	@DeleteMapping(path="/deleteAuthor")
	public @ResponseBody void deleteAuthor(@RequestParam long id) {
		authorService.deleteAuthor(id);
	}
	
	@Autowired
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}
	
}
