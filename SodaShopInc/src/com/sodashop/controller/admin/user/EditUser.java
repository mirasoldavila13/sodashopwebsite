package com.sodashop.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodashop.service.UserServ;


@WebServlet("/admin/edit_user")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EditUser() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServ userServ = new UserServ(request, response);
		userServ.editUser();
	}

}
