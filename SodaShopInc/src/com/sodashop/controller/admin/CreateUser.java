package com.sodashop.controller.admin;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodashop.service.UserServ;


@WebServlet("/admin/create_user")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		UserServ userServ = new UserServ(request,response);
		userServ.createUser();
		//after creating the user we want to refresh the page
		userServ.listUser("New User Created Successfully");
		
		
	}

}
