package com.sodashop.controller.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sodashop.entity.Users;
import com.sodashop.service.UserServ;
 
/**
 * Servlet implementation class ListUsers
 */
@WebServlet("/admin/list_users")
public class ListUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListUsers() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServ userServ = new UserServ();
		userServ.listUser(request, response, null); 
	}

}
