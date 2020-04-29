package com.sodashop.service;
import java.io.IOException;
import javax.persistence.EntityManager; 
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import com.sodashop.dao.UserDAO;
import com.sodashop.entity.Users;

public class UserServ {
	private UserDAO userDAO;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public UserServ() {
		// entityManager object
		entityManagerFactory = Persistence.createEntityManagerFactory("SodaShopInc");
		entityManager = entityManagerFactory.createEntityManager();
		// this is the instance of UserDAO class
		userDAO = new UserDAO(entityManager);
	}

	public List<Users> listUser() {
		List<Users> listUsers = userDAO.listAll();
		
		return listUsers;
		
	}
}
