package com.sodashop.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodashop.controller.admin.Base;
import com.sodashop.service.UserServ;

@WebServlet("/admin/update_user")
public class UpdateUser extends Base {
	private static final long serialVersionUID = 1L;
    
    public UpdateUser() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServ userServ = new UserServ(entityManager,request, response);
		userServ.updateUser();
	}

	
	
}
