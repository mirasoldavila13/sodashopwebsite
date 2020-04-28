package com.sodashop.dao;

import static org.junit.Assert.assertTrue; 
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.EntityNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sodashop.entity.Users;

public class UserDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO;

	@BeforeClass
	public static void setUpClass() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("SodaShopInc");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);

	}

	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("mary@gmail.com");
		user1.setFullName("MAry Something 3");
		user1.setPassword("johnnysss3");
		
		user1 = userDAO.create(user1);
		
		assertTrue(user1.getUserId() > 0);
	}
	
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldsNotSet() {
		Users user1 = new Users();		
		user1 = userDAO.create(user1);	
		assertTrue(user1.getUserId() > 0);
	}
	
	@Test
	public void testUpdateUsers() {
		Users user = new Users();
		user.setUserId(5);
		user.setEmail("Sunny@gmail.com");
		user.setFullName("Clara RR");
		user.setPassword("KFF123!hellooksm");
		
		user = userDAO.update(user);
		String expected = "KFF123!hellooksm";
		String actual = user.getPassword();
		
		assertEquals(expected, actual);
	}
	@AfterClass
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
