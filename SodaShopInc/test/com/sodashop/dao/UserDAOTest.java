package com.sodashop.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sodashop.entity.Users;

public class UserDAOTest {

	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("HELLOWORLD@LOL.com");
		user1.setFullName("My name is Fred");
		user1.setPassword("powertoyou");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SodaShopInc");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		UserDAO userDAO = new UserDAO(entityManager);
		user1 = userDAO.create(user1);
		entityManager.close();
		entityManagerFactory.close();
	}

}
