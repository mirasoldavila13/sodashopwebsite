package com.sodashop.controller.orders;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodashop.controller.Base;
import com.sodashop.service.OrderServ;

@WebServlet("/add_order")
public class AddOrderServlet extends Base {
	private static final long serialVersionUID = 1L;
	
	public AddOrderServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderServ orderServ = new OrderServ(entityManager,request,response);
		orderServ.listAllByCustomerId();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
