package com.sodashop.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sodashop.dao.ReviewDAO;
import com.sodashop.dao.SodaDAO;
import com.sodashop.entity.Customer;
import com.sodashop.entity.Review;
import com.sodashop.entity.Soda;

public class ReviewServ {
	protected EntityManager entityManager;
	private ReviewDAO reviewDAO;
	private SodaDAO sodaDao;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public ReviewServ(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
		reviewDAO = new ReviewDAO(entityManager);
		sodaDao = new SodaDAO(entityManager);
		
	}
	
	public void listAllReview() throws ServletException, IOException{
		listAllReview(null);
	}
	
	public void listAllReview(String message) throws ServletException, IOException {
		List<Review> listReviews = reviewDAO.listAll();
		
		request.setAttribute("listReviews", listReviews);
		String listPage = "review_list.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
		
	}
	

	

	public void updateReview() throws ServletException, IOException {
		Integer reviewId = Integer.parseInt(request.getParameter("reviewId"));
		String headline = request.getParameter("headline");
		String comment = request.getParameter("comment");
		
		Review review = reviewDAO.get(reviewId);
		review.setHeadline(headline);
		review.setComment(comment);
		
		reviewDAO.update(review);
		
		String message = "The review has been updated successfully.";
		
		listAllReview(message);
		
	}

	

	public void showReviewForm() throws ServletException, IOException {
		Integer sodaId = Integer.parseInt(request.getParameter("soda_id"));
		Soda soda = sodaDao.get(sodaId);
		
		HttpSession session = request.getSession(); 
		session.setAttribute("soda", soda);
		
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		
		Review existReview = reviewDAO.findByCustomerAndSoda(customer.getCustomerId(), sodaId);
		
		String formPage = "frontend/review_form.jsp";
		
		if (existReview != null) {
			request.setAttribute("review", existReview);
			formPage = "frontend/review_info.jsp";
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(formPage);
		requestDispatcher.forward(request, response);	}

	public void submitReview() throws ServletException, IOException {
		Integer sodaId = Integer.parseInt(request.getParameter("sodaId"));
		Integer rating = Integer.parseInt(request.getParameter("rating"));
		String headline = request.getParameter("headline");
		String comment = request.getParameter("comment");
		
		Review newReview = new Review();
		newReview.setHeadline(headline);
		newReview.setComment(comment);
		newReview.setRating(rating);
		
		Soda soda = new Soda();
		soda.setSodaId(sodaId);
		newReview.setSoda(soda);
		
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		newReview.setCustomer(customer);
		
		reviewDAO.create(newReview);
		String donePage = "frontend/review_done.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(donePage);
		requestDispatcher.forward(request, response);
		
			
	}
	
	public void createReview() throws ServletException, IOException {
		
		
		Soda soda = new Soda();
		Customer customer = new Customer();
		soda.setSodaId(1);
		customer.setCustomerId(1);
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		int sodaId = Integer.parseInt(request.getParameter("sodaId"));
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
		listAllReview("New Review created");
		
		
		
	}
	public void editReview() throws ServletException, IOException {
		Integer reviewId = Integer.parseInt(request.getParameter("id"));
		Review review = reviewDAO.get(reviewId);
		
		if (review != null) {		
			String editPage = "review_form.jsp";
			request.setAttribute("review", review);		
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
			requestDispatcher.forward(request, response);
		} else {
			String message = "Could not find review with ID " + reviewId;
			listAllReview(message);
		}
	}
	
	
	
	
	
	public void deleteReview() throws ServletException, IOException {
		Integer reviewId = Integer.parseInt(request.getParameter("id"));
		Review review = reviewDAO.get(reviewId);
		
		if (review != null) {
			reviewDAO.delete(reviewId);
			String message = "The review has been deleted successfully.";
			listAllReview(message);
		} else {
			String message = "Could not find review with ID " + reviewId
					+ ", or it might have been deleted by another admin";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(message);
			requestDispatcher.forward(request, response);
			
		}		
	}
	

}
