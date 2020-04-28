package com.sodashop.dao;

import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.sodashop.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
	}
	//create delegates to call its superclass; uses the specific entity type USer
	
	//create user
	public Users create(Users user) {
	 return super.create(user);
	}
	//update user
	@Override
	public Users update(Users user) {
		return super.update(user);
	}
	//get userid from the users class using the superclass find in jpaDAO
	@Override
	public Users get(Object userId) {
		return super.find(Users.class, userId);
	}

	public Users findByEmail(String email) {
		return null;
	}

	@Override
	public void delete(Object userId) {
		
	}

	@Override
	public List<Users> listAll() {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

}
