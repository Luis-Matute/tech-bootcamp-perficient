package com.perficient.techbootcamplmatute.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perficient.techbootcamplmatute.entities.BlogPostEntity;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPostEntity, Long>{
	
	BlogPostEntity findById(long id);
	
}
