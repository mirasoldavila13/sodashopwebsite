package com.sodashop.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodashop.controller.admin.Base;
import com.sodashop.service.UserServ;


@WebServlet("/admin/delete_user")
public class DeleteUser extends Base  {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteUser() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServ userServ = new UserServ(entityManager,request, response);
		userServ.deleteUser();
	}

}
