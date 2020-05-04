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
		listCategory(null);
		
	}
	public void listCategory(String message) throws ServletException, IOException {
		List<Category> listCategories = categoryDao.listAll();
		request.setAttribute("listCategories", listCategories);
		
		if(message != null) {
			request.setAttribute("message", message);
		}
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
			String message = "New Category Was Created Succesfully";
			listCategory(message);
			
		}
	}
	
	public void editCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		Category category = categoryDao.get(categoryId);
		String editPage = "category_form.jsp";
		
		if(category == null) {
			editPage = "message.jsp";
			String errorMessage = "Could not find Category with ID " + categoryId;
			request.setAttribute("message", errorMessage);
		}
		else {
			request.setAttribute("category", category);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
		
	}
	
	public void updateCreate() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String CategoryName = request.getParameter("name");
		
		Category categoryById = categoryDao.get(categoryId);
		Category categoryByName = categoryDao.findByName(CategoryName);
		
		if(categoryByName != null && categoryById.getCategoryId() != categoryByName.getCategoryId()) {
			String message = "Could not update category. Category with name" + CategoryName + " already exists.";
			request.setAttribute("message", message);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		}
		else {
			categoryById.setName(CategoryName);
			categoryDao.update(categoryById);
			String message = "Category has been updated successfully";
			listCategory(message);
		}

	}

	public void deleteCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		categoryDao.delete(categoryId);
		String message = "The Category " + categoryId + " has been deleted successfully";
		
		listCategory(message);
	
	}
}


