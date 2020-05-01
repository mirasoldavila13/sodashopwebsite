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
		//entityManager.close();

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
		if(entity != null) {
			//refresh the entity
			entityManager.refresh(entity);
		}
		
		return entity;
	}
	//delete entity 
	public void delete(Class<E> type, Object id) {
	//need to wrap it to transaction since its deleting from db
		entityManager.getTransaction().begin();

		Object reference = entityManager.getReference(type, id);
		entityManager.remove(reference);
		entityManager.getTransaction().commit();

		
	}
	
	//create method that gets reused to execute a query by subclasses
	public List<E> findWithNamedQuery(String queryName){
		Query query = entityManager.createNamedQuery(queryName);
		 return query.getResultList();
	}
	
	public List<E> findWithNamedQuery(String queryName, String parameterName, Object value){
		Query query = entityManager.createNamedQuery(queryName);
		query.setParameter(parameterName, value);
		
		return query.getResultList();
		
	}

	//this method returns a single query
	
	public long countQuery(String queryName) {
		Query query = entityManager.createNamedQuery(queryName);
		return (long) query.getSingleResult();

		
	}
	
}
