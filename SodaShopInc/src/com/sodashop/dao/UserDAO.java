package com.sodashop.dao;

import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.sodashop.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO() {
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
		List<Users> listUsers =  super.findWithNamedQuery("Users.findByEmail", "email", email);
		//validate
		if(listUsers != null && listUsers.size() > 0) {
			return listUsers.get(0);
		}
		
		return null;
	}

	@Override
	public void delete(Object userId) {
		super.delete(Users.class, userId);
	}
	//returns a lists
	@Override
	public List<Users> listAll() {
		return super.findWithNamedQuery("Users.findAll");
	}
	//returns a single list
	@Override
	public long count() {
		return super.countWithNamedQuery("Users.countAll");
		
	}
	
	public boolean checkLogin(String email, String password) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("email", email);
		parameters.put("password", password);
		
		List<Users> listUsers = super.findWithNamedQuery("Users.checkLogin", parameters);
		
		if (listUsers.size() == 1) {
			return true;
		}
		
		return false;
	
	}

}
