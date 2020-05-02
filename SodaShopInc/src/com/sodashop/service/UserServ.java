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
	private HttpServletRequest request;
	private  HttpServletResponse response;

	public UserServ(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		// entityManager object
		entityManagerFactory = Persistence.createEntityManagerFactory("SodaShopInc");
		entityManager = entityManagerFactory.createEntityManager();
		// this is the instance of UserDAO class
		userDAO = new UserDAO(entityManager);
	}
	
	public void listUser() throws ServletException, IOException {
		listUser(null);
		
	}
	
	
	//this method needs to refresh a list of users
	public void listUser(String message) throws ServletException, IOException {
		List<Users> listUsers = userDAO.listAll();
		request.setAttribute("listUsers", listUsers);
		
		if(message != null) {
			request.setAttribute("message", message);
		}
		
		
		String listPage = "user_list.jsp";
	   
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}
	
	public void createUser() throws ServletException, IOException {
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");
		//validating to see if there is an existing customer
		Users existingUser = userDAO.findByEmail(email);
		
		if(existingUser != null) {
			String message = "User with " + email + " already exist";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		}
		else {
			Users newUser = new Users(email, fullName, password);
			userDAO.create(newUser);
			listUser("New User Created Successfully");
		}
	}

	public void editUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		Users user = userDAO.get(userId);
		
//		System.out.println(user.getFullName());
		
		String editPage = "user_form.jsp";
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
	}



	public void updateUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");
		
//		System.out.println(userId + ": " + email + "," + fullName + "," + password);
		Users userById = userDAO.get(userId);
		Users userByEmail = userDAO.get(email);
		//validate
		if(userByEmail != null && userByEmail.getUserId() != userById.getUserId()) {
			String message = "Could not update user. User with email " + email + " already exists.";
			request.setAttribute("message", message);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		}
		else {
			Users user = new Users(userId, email, fullName, password);
			userDAO.update(user);
			String message = "User has been update successfully";
			listUser(message);
		}
	}
	
	
	
}
