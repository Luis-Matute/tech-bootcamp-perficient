package com.perficient.techbootcamplmatute.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.perficient.techbootcamplmatute.entities.AuthorEntity;
import com.perficient.techbootcamplmatute.entities.BlogPostEntity;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
	
	AuthorEntity findById(long id);
	
	@Query(
			value = "SELECT * FROM authors a WHERE a.username = :username",
			nativeQuery = true)
	AuthorEntity findByUsername(@Param("username") String username);
	
	
	@Query(
			value = "SELECT blog_posts.id,\r\n"
					+ "blog_posts.title,\r\n"
					+ "blog_posts.content,\r\n"
					+ "blog_posts.author_id\r\n"
					+ "FROM authors \r\n"
					+ "RIGHT JOIN blog_posts\r\n"
					+ "ON authors.id = blog_posts.author_id\r\n"
					+ "WHERE blog_posts.author_id = :author_id",
			nativeQuery = true
			)
	
	List<BlogPostEntity> getArticles(@Param("author_id") long authorId);
}
