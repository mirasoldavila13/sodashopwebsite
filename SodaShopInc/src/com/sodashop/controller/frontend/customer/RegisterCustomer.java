package com.sodashop.controller.frontend.customer;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodashop.controller.Base;
import com.sodashop.service.CustomerServ;

@WebServlet("/register_customer")
public class RegisterCustomer extends Base {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServ customerServ = new CustomerServ (entityManager,request, response);
		customerServ.registerCustomer();

	
	}

}
