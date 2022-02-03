package com.perficient.techbootcamplmatute.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.techbootcamplmatute.entities.BlogPostEntity;
import com.perficient.techbootcamplmatute.services.BlogPostService;

@RestController
@CrossOrigin(origins="*")
public class BlogPostController {
	
	private BlogPostService blogPostService;
	
	@RequestMapping(path="/allBlogPosts")
	public Iterable<BlogPostEntity> getAllBlogPosts() {
		
		return blogPostService.findAll();
	}
	
	@RequestMapping(path="/findBlogById")
	public ResponseEntity<BlogPostEntity> findBlogById(@RequestParam long id) {
		return new ResponseEntity<BlogPostEntity>(blogPostService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping("/createBlogPost")
	public void createBlogPost(@RequestBody BlogPostEntity blogPostEntity) {
		System.out.println(blogPostEntity);
		blogPostService.save(blogPostEntity);
	}
	
	@Autowired
	public void setBlogPostRepository(BlogPostService blogPostService) {
		this.blogPostService = blogPostService;
	}

}
