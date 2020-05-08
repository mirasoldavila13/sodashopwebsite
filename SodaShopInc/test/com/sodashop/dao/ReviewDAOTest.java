package com.sodashop.dao;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sodashop.entity.Customer;
import com.sodashop.entity.Review;
import com.sodashop.entity.Soda;
public class ReviewDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static ReviewDAO reviewDAO;
	
	
	@BeforeClass
	public static void setUpClass()throws Exception{
		entityManagerFactory = Persistence.createEntityManagerFactory("SodaShopInc");
		entityManager = entityManagerFactory.createEntityManager();
		reviewDAO = new ReviewDAO(entityManager);
	}
	
	
	
	@Test
	public void testListReview() {
		List<Review> listReviews = reviewDAO.listAll();
		for(Review review: listReviews) {
			// if you would like to see the reviews
			System.out.println(review.getComment() + " " + review.getReviewTime());
		}
		
		assertTrue(listReviews.size() > 0);
		
	}
	
	@Test
	public void testCreateReview() {
		Customer c1 = new Customer();
		c1.setCustomerId(2);
		Soda s1 = new Soda();
		s1.setSodaId(4);
		Review r1 = new Review();
		r1.setCustomer(c1);
		r1.setSoda(s1);
		r1.setComment("So very good");
		r1.setHeadline("Cool!");
		r1.setRating(9);
		r1 = reviewDAO.create(r1);
		assertTrue(r1.getReviewId()>0);
	}
	
	@Test
	public void testupdateReview() {
		Date reviewTime = new Date();
		Review review =  new Review();
		Customer c1 = new Customer();
		Soda s1 = new Soda();
		s1.setSodaId(1);
		c1.setCustomerId(1);
		review.setReviewId(1);
		review.setSoda(s1);
		review.setComment("It's really good");
		review.setHeadline("WOWZ");
		review.setRating(10);
		review.setReviewTime(reviewTime);
		review.setCustomer(c1);
		review = reviewDAO.update(review);
		String expected = "It's really good";
		String actual = review.getComment();
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testFindReview() {
		Integer reviewId = 1;
		Review review = reviewDAO.get(reviewId);
		if(review != null) {
			System.out.println(review.getHeadline());
		}
		assertNotNull(review);
	}
	
	@Test
	public void testDeleteReview() {
		Integer reviewId = 3;
		reviewDAO.delete(reviewId);
		Review review = reviewDAO.get(reviewId);
		assertNull(review);
		
		
	}
	
	@Test
	public void testCount() {
		long totalReviews = reviewDAO.count();
		assertEquals(10, totalReviews);
	}
	
	@Test
	public void testFindByCustomerAndSoda() {
		List<Review> listReviews = reviewDAO.findByCustomerAndSoda(3,1);
		for(Review review: listReviews) {
			// if you would like to see the reviews
			System.out.println(review.getComment());
		}
		
		assertEquals(1, listReviews.size());
		
	}
	
//	@Test
//	public void testCountByCustomer() {
//		Customer c1 = new Customer();
//		Integer customerId = 1;
//		c1.setCustomerId(customerId);
//		long totalCustomerReviews = reviewDAO.countByCustomer(customerId);
//		assertEquals(2, totalCustomerReviews);
//	}
	
}
