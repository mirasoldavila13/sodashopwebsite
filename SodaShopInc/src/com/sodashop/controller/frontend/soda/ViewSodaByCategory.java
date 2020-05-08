package com.sodashop.controller.frontend.soda;

import com.sodashop.controller.Base;
import com.sodashop.service.SodaServ;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view_category")
public class ViewSodaByCategory extends Base {
	private static final long serialVersionUID = 1L;

 
    public ViewSodaByCategory() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SodaServ sodaServ = new SodaServ(entityManager,request,response);
		sodaServ.listSodaByCategory();
	
	}

}
