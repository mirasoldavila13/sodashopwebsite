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

import com.sodashop.controller.Base;
import com.sodashop.dao.UserDAO;
import com.sodashop.entity.Category;
import com.sodashop.entity.Users;

public class UserServ  {
	protected EntityManager entityManager;
	private UserDAO userDAO;
	private HttpServletRequest request;
	private  HttpServletResponse response;

	public UserServ(EntityManager entityManager,HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
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

		String editPage = "user_form.jsp";
		
		if (user == null) {
			editPage = "message.jsp";
			String errorMessage = "Could not find user with ID " + userId;
			request.setAttribute("message", errorMessage);
		} else {
			request.setAttribute("user", user);			
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
		
	}


	public void updateUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));		
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");
		
//		System.out.println(userId + ": " + email + "," + fullName + "," + password);
		Users userById = userDAO.get(userId);
//		Users userByEmail = userDAO.get(email);
		Users userByEmail = userDAO.findByEmail(email);

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

			String message = "User has been updated successfully";
			listUser(message);
		}
	}

	public void deleteUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		
		Users user = userDAO.get(userId);
		String message = "User has been deleted successfully";
		
		if (user == null) {
			message = "Could not find user with ID " + userId
					+ ", or it might have been deleted by another admin";
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("message.jsp").forward(request, response);			
		} else {
			userDAO.delete(userId);
			listUser(message);
		}		
	}
	
	public void login() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean login = userDAO.checkLogin(email, password);
		
		if(login) {
			request.getSession().setAttribute("userEmail", email);
			//after use is athenticated we shou the admin homepage
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");
			dispatcher.forward(request, response);
		}
		else {
			String message = "Login Failed";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	
}
