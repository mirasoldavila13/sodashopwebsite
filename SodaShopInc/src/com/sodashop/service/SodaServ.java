package com.sodashop.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sodashop.dao.SodaDAO;
import com.sodashop.entity.Soda;

public class SodaServ {
	private EntityManager entityManager;
	private SodaDAO sodaDAO;
	private HttpServletRequest request;
	private  HttpServletResponse response;
	
	
	

	public SodaServ(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		super();
		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
		sodaDAO = new SodaDAO(entityManager);
	}




	public void listSoda() throws ServletException, IOException {
		List<Soda> listSoda = sodaDAO.listAll();
		request.setAttribute("listSoda", listSoda);
		
		String listPage = "soda_list.jsp";
	   
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}

}
