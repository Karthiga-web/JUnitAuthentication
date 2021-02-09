package com.hcl.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.Rollback;

import com.hcl.entity.JunitEntity;


@DataJpaTest
public class DataTest {

	static JunitEntity entity;
	
	@TestConfiguration
    static class JunitServiceImplTestContextConfiguration {
 
        @Bean
        public JunitService employeeService() {
            return new JunitServiceImpl();
        }
    }

	@Autowired
	private JunitServiceImpl r;
	
	@BeforeAll
	static void beforeAll() {
		entity = new JunitEntity();
		System.out.println("Initialize connection to database");
	}
	
	@Test
	@Rollback(false)
	public void saveTest() {
		entity.setEmail("dfb");
		entity.setId(2);
		entity.setFirstname("xfbx");
		entity.setLastname("xfvbxf");
		entity.setPassword("xfvbcxfb");
		entity.setUsername("xdfbxf");
		r.update(entity);
		entity.setEmail("a");
		entity.setId(1);
		entity.setFirstname("a");
		entity.setLastname("a");
		entity.setPassword("a");
		entity.setUsername("a");
		r.update(entity);
		entity.setEmail("b");
		entity.setId(2);
		entity.setFirstname("b");
		entity.setLastname("b");
		entity.setPassword("b");
		entity.setUsername("b");
		r.update(entity);
		entity.setEmail("c");
		entity.setId(3);
		entity.setFirstname("c");
		entity.setLastname("c");
		entity.setPassword("c");
		entity.setUsername("c");
		r.update(entity);
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("Close connection to database");
	}

	@Test
	public void findByUsernameTest() {
		entity.setUsername("b");
		JunitEntity news = r.findByUsername(entity.getUsername()).get();
		assertEquals(news.getUsername(), entity.getUsername());
		
		entity.setUsername("dxfbd");
		
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			r.findByUsername(entity.getUsername()).get();
		  });
	}

	@Test
	public void existsByUsernameAndPasswordTest() {
		entity.setUsername("c");
		entity.setPassword("c");
		assertTrue(r.existsByUsernameAndPassword(entity.getUsername(), entity.getPassword()));
		entity.setUsername("2");
		entity.setPassword("4");
		assertFalse(r.existsByUsernameAndPassword(entity.getUsername(), entity.getPassword()));
	}

	@Test
	public void findByIdTest() {
		entity.setId(2);
		JunitEntity news = r.findById(entity.getId()).get();
		assertEquals(news.getId(), entity.getId());
	}

}