package com.sodashop.controller.admin.category;

import java.io.IOException ; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodashop.controller.Base;
import com.sodashop.service.CategoryServ;


@WebServlet("/admin/create_category")
public class CreateCategory extends  HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CreateCategory() {
        
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryServ categoryServ = new CategoryServ(request, response);
		categoryServ.createCategory();
	}

}
