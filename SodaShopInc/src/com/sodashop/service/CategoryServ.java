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
}
