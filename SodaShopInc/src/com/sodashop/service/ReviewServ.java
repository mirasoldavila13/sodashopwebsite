package com.sodashop.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodashop.dao.ReviewDAO;
import com.sodashop.entity.Customer;
import com.sodashop.entity.Review;
import com.sodashop.entity.Soda;

public class ReviewServ {
	protected EntityManager entityManager;
	private ReviewDAO reviewDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public ReviewServ(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
		reviewDAO = new ReviewDAO(entityManager);
		
	}
	
	public void listReview() throws ServletException, IOException{
		listReview(null);
	}
	
	public void listReview(String message) throws ServletException, IOException {
		List<Review> listReview = reviewDAO.listAll();
		request.setAttribute("reviewList", listReview);
		
		if(message != null) {
			request.setAttribute("message", message);
		}
		 //Not sure if this will be the jsp for listing reviews
		String listPage = "review_list.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
		
	}
	
	
	
	public void createReview() throws ServletException, IOException {
		
		
		Soda soda = new Soda();
		Customer customer = new Customer();
		soda.setSodaId(1);
		customer.setCustomerId(1);
//		int customerId = Integer.parseInt(request.getParameter("customerId"));
//		int sodaId = Integer.parseInt(request.getParameter("sodaId"));
		String headline = request.getParameter("headline");
		String comment = request.getParameter("comment");
		int rating = Integer.parseInt(request.getParameter("rating"));
		Review newReview = new Review();
		newReview.setComment(comment);
		newReview.setHeadline(headline);
		newReview.setRating(rating);
		newReview.setCustomer(customer);
		newReview.setSoda(soda);
		
		
		reviewDAO.create(newReview);
		listReview("New Review created");
		
		
		
	}
	
//	public void editReview() throws ServletException, IOException{
//		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
//		Review review = reviewDAO.get(reviewId);
//		// Might need to actual name of jsp
//		String editPage = "review_form.jsp";
//		
//		if(review == null) {
//			editPage = "message.jsp";
//			String errorMessage = "Could not find review with ID " + reviewId;
//			request.setAttribute("message", errorMessage);
//		} else {
//			request.setAttribute("review", review);
//			
//			
//		}
//		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
//		requestDispatcher.forward(request, response);
//	}
	
	public void updateReview() throws ServletException, IOException {
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		
	}
	
	public void deleteReview() throws ServletException, IOException{
		Integer reviewId = Integer.parseInt(request.getParameter("reviewId"));
		
		Review review = reviewDAO.get(reviewId);
		String message = "Review has successfully deleted";
		
		if(review == null) {
			message = "Could not find review with ID " + reviewId + ", or has been deleted by the admin";
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("message.jsp").forward(request, response);
			
		} else {
			reviewDAO.delete(reviewId);
			listReview(message);
			
		}
	}
}