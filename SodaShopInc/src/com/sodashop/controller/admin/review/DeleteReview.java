package com.sodashop.controller.admin.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sodashop.controller.Base;
import com.sodashop.service.ReviewServ;

@WebServlet("/admin/delete_review")
public class DeleteReview extends Base  {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteReview() {
       
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewServ reviewServ = new ReviewServ(entityManager,request, response);
		reviewServ.deleteReview();
	}

}