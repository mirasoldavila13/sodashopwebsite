package com.sodashop.controller.frontend.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodashop.controller.Base;
import com.sodashop.service.ReviewServ;


@WebServlet("/update_review")
public class UpdateReview extends Base {
	private static final long serialVersionUID = 1L;
    
    public UpdateReview() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewServ reviewServ = new ReviewServ(entityManager,request, response);
		reviewServ.updateReview();
	}

}
