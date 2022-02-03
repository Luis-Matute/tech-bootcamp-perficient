package com.perficient.techbootcamplmatute.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perficient.techbootcamplmatute.entities.BlogPostEntity;
import com.perficient.techbootcamplmatute.exceptions.ResourceNotFoundException;
import com.perficient.techbootcamplmatute.jpa.BlogPostRepository;


@Service
public class BlogPostService {
	
	private BlogPostRepository blogPostRepository;
	
	public BlogPostEntity findById(long id) {
		return blogPostRepository.findById((Long) id).orElseThrow(() -> 
				new ResourceNotFoundException("Blog Post", "ID", id));
	}
	
	public Iterable<BlogPostEntity> findAll() {
		return blogPostRepository.findAll();
	}
	
	public void save(BlogPostEntity blogPostEntity) {
		blogPostRepository.save(blogPostEntity);
	}
	
	@Autowired
	public void setBlogPostRepository(BlogPostRepository blogPostRepository) {
		this.blogPostRepository = blogPostRepository;
	}
	
}
