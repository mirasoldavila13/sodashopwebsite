package com.sodashop.controller.admin.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodashop.controller.Base;
import com.sodashop.service.ReviewServ;

@WebServlet("/admin/listreview")
public class ListReview extends Base {
	private static final long serialVersionUID = 1L;
    
    public ListReview() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ReviewServ reviewServ = new ReviewServ(entityManager,request, response);
			reviewServ.listReview();
		
	}

}


