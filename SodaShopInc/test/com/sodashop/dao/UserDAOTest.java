package com.sodashop.dao;

import static org.junit.Assert.assertTrue; 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
		user1.setEmail("Seren@yahoo.com");
		user1.setFullName("Serenity Hutchens");
		user1.setPassword("pwd!");
		
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
		user.setUserId(6);
		user.setEmail("fkmfkf@gmail.com");
		user.setFullName("Hello its me");
		user.setPassword("rrerw3443444334");
		
		user = userDAO.update(user);
		String expected = "rrerw3443444334";
		String actual = user.getPassword();
		
		assertEquals(expected, actual);
	}
	//using find from jpa to get a use
	@Test
	public void testFindUsers() {
		Integer userId = 1;
		Users user = userDAO.get(userId);
		
		if(user != null) {
			System.out.println(user.getEmail());
		}
		assertNotNull(user);
	}
	
	@Test
	public void testUserNotFound() {
		Integer userId = 99;
		Users user = userDAO.get(userId);
		assertNull(user);
	}
	
	@Test
	public void testDeleteUser() {
		Integer userId = 7;
		userDAO.delete(userId);
		
		Users user = userDAO.get(userId);
		
		assertNull(user);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNonUser() {
		Integer userId = 35;
		userDAO.delete(userId);
	}
	
	@Test
	public void testListAll() {
		List<Users> listUser =  userDAO.listAll();
		//if you want to see it actually print 
		for(Users user: listUser) {
			System.out.println(user.getEmail());
		}
		assertTrue(listUser.size() > 0);
		
	}
	
	@Test
	public void testCount() {
		long totalUsers = userDAO.count();
		/*this test is test to see if I have 10 users in the db  with the total users
		 * when you do this test please refer to how many rows/users you have
		 * */
		assertEquals(10,totalUsers);
	}
	@AfterClass
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
