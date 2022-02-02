package com.perficient.techbootcamplmatute.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.techbootcamplmatute.entities.BlogPostEntity;
import com.perficient.techbootcamplmatute.jpa.BlogPostRepository;

@RestController
@CrossOrigin(origins="*")
public class BlogPostController {
	
	private BlogPostRepository blogPostRepository;
	
	@RequestMapping(path="/allBlogPosts")
	public Iterable<BlogPostEntity> getAllBlogPosts() {
		
		return blogPostRepository.findAll();
	}
	
	@PostMapping("/createBlogPost")
	public void createBlogPost(@RequestBody BlogPostEntity blogPostEntity) {
		System.out.println(blogPostEntity);
	}
	
	@Autowired
	public void setBlogPostRepository(BlogPostRepository blogPostRepository) {
		this.blogPostRepository = blogPostRepository;
	}

}
