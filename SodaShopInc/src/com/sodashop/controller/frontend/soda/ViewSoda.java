package com.sodashop.controller.frontend.soda;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodashop.controller.Base;
import com.sodashop.service.SodaServ;


@WebServlet("/view_soda")
public class ViewSoda extends  HttpServlet{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SodaServ sodaServ = new SodaServ(request, response);
		sodaServ .viewSodaDetail();
	}

}
