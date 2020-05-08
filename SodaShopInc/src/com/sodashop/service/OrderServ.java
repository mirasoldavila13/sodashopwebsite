package com.sodashop.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodashop.dao.OrderDAO;
import com.sodashop.entity.OrderDetail;
import com.sodashop.entity.SodaOrder;

public class OrderServ {
	
	protected EntityManager entityManager;
	private OrderDAO orderDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public OrderServ(EntityManager entityManager,HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
		orderDAO = new OrderDAO(entityManager);
	}
	
	public void listAllSodaOrder() throws ServletException, IOException {
		listAllSodaOrder(null);	
	}
	
	public void listAllSodaOrder(String message) throws ServletException, IOException {
		List<SodaOrder> listAllSodaOrder = orderDAO.listAll();
		request.setAttribute("listAllSodaOrder", listAllSodaOrder);
		
		if(message != null) {
			request.setAttribute("message", message);
		}
		
		
		String listPage = "order_list.jsp";
	   
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}
	
	public void listByOrderId() throws ServletException, IOException {
		listByOrderId(null);	
	}
	
	//soda order found by order id
	public void listByOrderId(String message) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		List<SodaOrder> listByOrderId = orderDAO.findWithNamedQuery("SodaOrder.findByOrderId", "id", id);
		
		request.setAttribute("listByOrderId", listByOrderId);
		
		String listPage = "order_list.jsp";
		   
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}
	
	public void listByCustomerId() throws ServletException, IOException {
		listByCustomerId(null);	
	}
	
	//soda order with its corresponding customer (first constructor)
	public void listByCustomerId(String message) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		List<SodaOrder> listByCustomerId = orderDAO.findWithNamedQuery("SodaOrder.findByCustomerId", "id", id);
		
		request.setAttribute("listByCustomerId", listByCustomerId);
		
		String listPage = "order_list.jsp";
		   
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}
	
	public void listAllByCustomerId() throws ServletException, IOException {
		listAllByCustomerId(null);	
	}
	
	//soda order with its corresponding order detail and customer (second constructor)
	public void listAllByCustomerId(String message) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		List<SodaOrder> listAllByCustomerId = orderDAO.findWithNamedQuery("SodaOrder.findAllByCustomerId", "id", id);
		
		request.setAttribute("listAllByCustomerId", listAllByCustomerId);
		
		String listPage = "order_list.jsp";
		   
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}
	

}
