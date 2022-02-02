package com.perficient.techbootcamplmatute.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.perficient.techbootcamplmatute.entities.AuthorEntity;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
	
	AuthorEntity findById(long id);
	
}
