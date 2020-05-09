package com.sodashop.controller.frontend.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodashop.controller.Base;
import com.sodashop.service.CustomerServ;


@WebServlet("/edit_profile")
public class EditCustomerProfile extends Base{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServ customerServ = new CustomerServ(entityManager,request, response);
		customerServ.showCustomerProfileEditForm();
	}

}
