package com.hcl.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized.Parameters;
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
		entity.setEmail("a");
		entity.setId(2);
		entity.setFirstname("xfbx");
		entity.setLastname("xfvbxf");
		entity.setPassword("xfvbcxfb");
		entity.setUsername("xdfbxf");
		r.update(entity);
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("Close connection to database");
	}

	@BeforeEach
	public void setUp() {
//		entity = new JunitEntity();
	}

//	@Parameters
//	public static List<JunitEntity> testconditions() {
//		List<JunitEntity> list = new ArrayList<>();
//		entity.setEmail("a");
//		entity.setId(1);
//		entity.setFirstname("a");
//		entity.setLastname("a");
//		entity.setPassword("a");
//		entity.setUsername("a");
//		list.add(entity);
//		entity.setEmail("b");
//		entity.setId(2);
//		entity.setFirstname("b");
//		entity.setLastname("b");
//		entity.setPassword("b");
//		entity.setUsername("b");
//		list.add(entity);
//		entity.setEmail("c");
//		entity.setId(3);
//		entity.setFirstname("c");
//		entity.setLastname("c");
//		entity.setPassword("c");
//		entity.setUsername("c");
//		list.add(entity);
//		return list;
//	}
//	
//	@Test
//	public void multipleSaveTest() {
//		for(int i =0;i < )
//		r.update(entity);
//	}
	
	@Test
	public void findByUsernameTest() {
		entity.setUsername("xdfbxf");
		JunitEntity news = r.findByUsername(entity.getUsername()).get();
		assertEquals(news.getId(), entity.getId());
	}

	@Test
	public void existsByUsernameAndPasswordTest() {
		entity.setUsername("xdfbxf");
		entity.setPassword("xfvbcxfb");
		assertTrue(r.existsByUsernameAndPassword(entity.getUsername(), entity.getPassword()));
	}

	@Test
	public void findByIdTest() {
		entity.setId(2);
		JunitEntity news = r.findById(entity.getId()).get();
		assertEquals(news.getId(), entity.getId());
	}

}