package com.sodashop.entity;
import javax.persistence.EntityManager; 
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sodashop.entity.Users;

public class UsersTest {
	public static void main(String[] args) {
		Users user1 = new Users();
		user1.setEmail("you@gmail.com");
		user1.setFullName("Mom Apple Pie");
		user1.setPassword("power");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SodaShopInc");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(user1);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("A Users object was persisted");
	}

}
