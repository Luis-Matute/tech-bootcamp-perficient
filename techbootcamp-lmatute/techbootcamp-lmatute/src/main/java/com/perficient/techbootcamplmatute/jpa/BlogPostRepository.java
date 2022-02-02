package com.perficient.techbootcamplmatute.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.perficient.techbootcamplmatute.entities.BlogPostEntity;

@Repository
public interface BlogPostRepository extends CrudRepository<BlogPostEntity, Long> {
	
	BlogPostEntity findById(long id);
	
}
