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
	//this is the parent class of UserDAO
	

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

	//first parameter is a class type
	public E find(Class<E> type, Object id) {
		E entity = entityManager.find(type, id);
		//refresh the entity
		entityManager.refresh(entity);
		return entity;
		
	}
}
