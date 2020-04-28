package com.sodashop.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sodashop.entity.Users;

public class CategoryTest {

	public static void main(String[] args) {
		Category newCategory = new Category("Not Good");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SodaShopInc");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.persist(newCategory);

		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

		System.out.println("A Category object was persisted");
	}
}
