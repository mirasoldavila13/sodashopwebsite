package com.sodashop.service;


import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sodashop.dao.SodaDAO;
import com.sodashop.dao.CategoryDAO;
import com.sodashop.entity.Category;
import com.sodashop.entity.Soda;
import com.sodashop.entity.Users;

public class SodaServ {
	private EntityManager entityManager;
	private SodaDAO sodaDAO;
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private  HttpServletResponse response;
	
	
	

	public SodaServ(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		super();
		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
		sodaDAO = new SodaDAO(entityManager);
		categoryDAO = new CategoryDAO(entityManager);
	}




	public void listSoda() throws ServletException, IOException {
		listSoda(null);
	}

	private void listSoda(String message) throws ServletException, IOException {
		List<Soda> listSoda = sodaDAO.listAll();
		request.setAttribute("listSoda", listSoda);
		
		if(message != null) {
			request.setAttribute("message", message);
		}
		
		
		String listPage = "soda_list.jsp";
	   
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
		
	}
	
	public void showSodaNewForm() throws ServletException, IOException {
		List<Category> listCategory = categoryDAO.listAll();
		request.setAttribute("listCategory", listCategory);
		
		String newPage = "soda_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(newPage);
		dispatcher.forward(request, response);
	}


	public void createSoda() throws ServletException, IOException {
		String name = request.getParameter("name");
		
		Soda existSoda = sodaDAO.findByName(name);
		
		if (existSoda!= null) {
			String message = "Could not create new soda because the name '"
					+ name + "' already exists.";
			listSoda(message);
			return;
		}
		
		Soda newSoda = new Soda();
			readSodaFields(newSoda);
		
		Soda createdSoda = sodaDAO.create(newSoda);
		
		if (createdSoda.getSodaId() > 0) {
			String message = "A new soda has been created successfully.";
			listSoda(message);
		}
	}




	private void readSodaFields(Soda soda) throws ServletException, IOException {
		String name = request.getParameter("name");
		String manufacture = request.getParameter("manufacture");
		String description = request.getParameter("description");
		float price = Float.parseFloat(request.getParameter("price"));
		String quantityInStock = request.getParameter("quantity");
			
		soda.setName(name);
		soda.setManufacture(manufacture);
		soda.setDescription(description);
		
		
		
		
		Integer categoryId = Integer.parseInt(request.getParameter("category"));
		Category category = categoryDAO.get(categoryId);
		soda.setCategory(category);
		
		soda.setPrice(price);
		
		Part part = request.getPart("sodaImage");
		
		if (part != null && part.getSize() > 0) {
			long size = part.getSize();
			byte[] imageBytes = new byte[(int) size];
			
			InputStream inputStream = part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
			
			soda.setImage(imageBytes);
		}
		
	}




	public void editSoda() throws ServletException, IOException {
		Integer sodaId = Integer.parseInt(request.getParameter("id"));
		Soda soda = sodaDAO.get(sodaId);
		
		String editPage = "soda_form.jsp";
			if(soda != null) {
			List<Category> listCategory = categoryDAO.listAll();
			
			request.setAttribute("soda", soda);

			request.setAttribute("listCategory", listCategory);
			}
			else {
				editPage="message.jsp";
				String message = "Could not find soda with ID: " + sodaId;
				request.setAttribute("message", message);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
			dispatcher.forward(request, response);
			
			
	}




	public void updateSoda() throws ServletException, IOException {
		Integer sodaId = Integer.parseInt(request.getParameter("sodaId"));
		
		Soda existSoda = sodaDAO.get(sodaId);
		String name = request.getParameter("name");
		Soda sodaByName = sodaDAO.findByName(name);
		
		if (sodaByName != null && !existSoda.equals(sodaByName)) {
			String message = "Could not update soda because there's another soda having same name.";
			listSoda(message);
			return;
		}
		readSodaFields(existSoda);
		
		sodaDAO.update(existSoda);
		
		String message = "The soda has been updated successfully.";
		listSoda(message);
		
	}




	public void deleteSoda() throws ServletException, IOException {
		Integer sodaId = Integer.parseInt(request.getParameter("id"));
		Soda soda = sodaDAO.get(sodaId);

		if(soda == null) {
			String message = "Could not find soda with ID " + sodaId + ", or it might have been deleted by another admin";
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("message.jsp").forward(request, response);	
		}
		else {
			String message = "The Soda has been deleted successfully";
			sodaDAO.delete(sodaId);
			listSoda(message);
		}

	}




	public void listSodaByCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		
		List<Soda> listSoda = sodaDAO.listByCategory(categoryId);
		Category category = categoryDAO.get(categoryId);
		List<Category> listCategory = categoryDAO.listAll();
		
		request.setAttribute("listCategory", listCategory);
		request.setAttribute("listSoda", listSoda);
		request.setAttribute("category", category);
		
		String listPage = "frontend/soda_list_by_category.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);

		
	}




	

}
