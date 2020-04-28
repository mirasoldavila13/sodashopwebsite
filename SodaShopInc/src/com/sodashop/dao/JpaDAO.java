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
	
	
	protected static EntityManager entityManager;
	// purpose of jpaDAO is providing common operations that are shared among the
	// subclasses but it does not implement genericDAO
	// dao is subclasses of jpaDAO class
	
	

	public JpaDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	// returns an entity object
	public E create(E entity) {
		
		entityManager.getTransaction().begin();

		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);

		entityManager.getTransaction().commit();
		entityManager.close();

		return entity;
	}
	
	public E update(E entity) {
		entityManager.getTransaction().begin();
		
		entity = entityManager.merge(entity);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return entity;
	}

}
