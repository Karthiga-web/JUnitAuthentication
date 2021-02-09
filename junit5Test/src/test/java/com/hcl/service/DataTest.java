package com.hcl.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.hcl.entity.JunitEntity;
import com.hcl.repository.JunitRepository;
@DataJpaTest
public class DataTest {

	
	JunitEntity entity;
	@Autowired
	private JunitRepository r;
	
	
//	@Test
//	public void findByUsername() {
//		JunitEntity entityj = getJunitEntity();
//		Optional<JunitEntity> news = r.findByUsername(entityj.getUsername());
//		
//		assertTrue(news.isPresent());
//	}
//	@Test
//	public void findById() {
//		JunitEntity entityj = getJunitEntity();
//		JunitEntity news = r.findById(entityj.getId()).get();
//		assertEquals(news.getId(),entityj.getId());
////		assertTrue(news.isPresent());
//	}

	@BeforeEach
	public void setUp() {
		entity = new JunitEntity();
	}
	
	@Test
	public void findByIdTest() {
		entity.setEmail("a");
		entity.setId(2);
		entity.setFirstname("xfbx");
		entity.setLastname("xfvbxf");
		entity.setPassword("xfvbcxfb");
		entity.setUsername("xdfbxf");
		r.save(entity);
//		JunitEntity news = r.findByUsername(entity.getUsername()).get();
		assertTrue(r.existsByUsernameAndPassword(entity.getUsername(),entity.getPassword()));
		JunitEntity news = r.findById(entity.getId()).get();
		assertEquals(news.getId(),entity.getId());
	}

//    @Test
//    public void whenFindByName_thenReturnUser() {
//        // given
//
//        User dummyUser = new User();
//        dummyUser.setName("Dummy");
//        dummyUser.setEmail("test@test.com");
//        dummyUser.setPassword("password");
//        entityManager.persist(dummyUser);
//        entityManager.flush();
//
//        // when
//        User found = userRepository.findByName(dummyUser.getName());
//
//        // then
//
//        assertEquals(found.getName(), dummyUser.getName());
//    }

//	@Test
//	@DisplayName("assert Examples")
//	public void assertTests() {
//		JunitEntity entity = new JunitEntity();
////    	JunitEntity entity1 = new JunitEntity();
//		entity.setEmail("a");
//		entity.setId(2);
//		entity.setFirstname("xfbx");
//		entity.setLastname("xfvbxf");
//		entity.setPassword("xfvbcxfb");
//		entity.setUsername("xdfbxf");
//
////		String a = j.saveMethod(entity);
//		entity.getEmail();
//		entityManager.persist(entity);
//		entityManager.flush();
////		service.update(entity).getEmail();
////		entity1 = service.update(entity);
////		assertEquals(entity.getEmail(),service.update(entity).getEmail());
////		assertTrue(a.equalsIgnoreCase("Error"));
////		assertTrue(j.check("d","d"));
////		assertFalse(j.check("d","cdfbc"));
//
//		service.existsByUsernameAndPassword("a", "b");
//		assertThrows(RuntimeException.class, () -> {
//			throw new RuntimeException();
//		});
//	}

	/*
	 * public void AddAndCheckUser() { JunitServiceImpl service = new
	 * JunitServiceImpl(); User dummyUser = new User(); dummyUser.setName("Dummy");
	 * dummyUser.setEmail("test@test.com"); dummyUser.setPassword("password");
	 * service.AddUser(dummyUser); boolean authenticated =
	 * service.AuthenticateUser(dummyUser, "password");
	 * assertThat(authenticated).isEqualTo(true); //assertEquals(authenticated,
	 * true); }
	 */

}