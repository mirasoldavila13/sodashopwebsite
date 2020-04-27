package com.sodashop.dao;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class JpaDAO<E> {
private static EntityManagerFactory entityManagerFactory;
	//purpose of jpaDAO is providing common operations that are shared among the subclasses but it does not implement genericDAO	
	//dao is subclasses of jpaDAO class
	static {
		//EntityManager is injected by the cliend code dao classes
		entityManagerFactory = Persistence.createEntityManagerFactory("SodaShopInc");
	}
	
	public JpaDAO() {
	}
	
	//returns an entity object
	public E create(E entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return entity;
	}
	
	
}
