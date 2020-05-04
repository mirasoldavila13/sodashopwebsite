package com.sodashop.controller.admin.user;

import java.io.IOException; 
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodashop.controller.Base;
import com.sodashop.entity.Users;
import com.sodashop.service.UserServ;
 

@WebServlet("/admin/list_users")
public class ListUsers extends Base {
	private static final long serialVersionUID = 1L;
       
    
    public ListUsers() {
       
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServ userServ = new UserServ(entityManager,request,response);
		userServ.listUser(); 
	}

}
