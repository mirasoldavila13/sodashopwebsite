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

import com.sodashop.controller.admin.Base;
import com.sodashop.dao.CategoryDAO;
import com.sodashop.dao.UserDAO;
import com.sodashop.entity.Category;
import com.sodashop.entity.Users;

public class CategoryServ{
	private EntityManager entityManager;
	private CategoryDAO categoryDao;
	private HttpServletRequest request;
	private  HttpServletResponse response;
	
	
	public CategoryServ(EntityManager entityManager,HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
		// this is the instance of UserDAO class
		categoryDao = new CategoryDAO(entityManager);
	}
	
	public void listCategory() throws ServletException, IOException {
		List<Category> listCategories = categoryDao.listAll();
		request.setAttribute("listCategories", listCategories);
		
		String categoryPage = "category_list.jsp";
		   
		RequestDispatcher dispatcher = request.getRequestDispatcher(categoryPage);
		dispatcher.forward(request, response);
			
		
	}
	
	public void createCategory() throws ServletException, IOException {
		String name = request.getParameter("name");
		Category existCategory = categoryDao.findByName(name);
		
		if(existCategory != null) {
			String message = "Category with name " + name + " already exist";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		}
		else {
			Category newCategory = new Category(name);
			categoryDao.create(newCategory);
			listCategory();
			
		}
	}
}


