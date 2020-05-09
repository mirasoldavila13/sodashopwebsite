package com.sodashop.controller.admin.user.soda;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodashop.controller.Base;
import com.sodashop.service.SodaServ;


@WebServlet("/admin/new_soda")
public class NewSoda extends  HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SodaServ sodaServ = new SodaServ(request, response);
		sodaServ.showSodaNewForm();
	}

}
