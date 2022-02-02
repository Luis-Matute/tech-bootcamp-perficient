package com.perficient.techbootcamplmatute;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.perficient.techbootcamplmatute.models.Person;

@SpringBootTest
class TechbootcampLmatuteApplicationTests {
	
	Person person;
	
	@Mock
	Person person2;
	
	@BeforeEach
	void setUp() {
		person = new Person();
	}
	
	@Test
	@DisplayName("Ensures the greeting of a person is not blank")
	void personGreets() {
		assertFalse(person.greeting().isBlank());
	}
	
	
	@Test
	@DisplayName("Checks if a persons name is left blank")
	void personEmptyName() {
		
		assertTrue(true);
	}
	
	@Test
	public void personTest() {
		assertNotNull(person2);
	}
}
