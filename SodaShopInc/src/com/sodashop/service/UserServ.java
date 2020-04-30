package com.sodashop.service;
import java.util.List;
import java.io.IOException; 
import javax.persistence.EntityManager; 
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
	
	//this method needs to refresh a list of users
	public void listUser(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
		List<Users> listUsers = userDAO.listAll();
		request.setAttribute("listUsers", listUsers);
		
		if(message != null) {
			request.setAttribute("message", message);
		}
		
		
		String listPage = "user_list.jsp";
	   
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
		

	}
	
	public void createUser(HttpServletRequest request, HttpServletResponse response){
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");
		
		Users newUser = new Users(email, fullName, password);
		userDAO.create(newUser);
		
		
	}
}
