package com.sodashop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.persistence.EntityManager;

import com.sodashop.entity.Customer;
import com.sodashop.entity.Review;
import com.sodashop.entity.Soda;

public class ReviewDAO extends JpaDAO<Review> implements GenericDAO<Review> {

	public ReviewDAO(EntityManager entityManager) {
		super(entityManager);
	}

	public Review create(Review review) {
		return super.update(review);
	}
	
	@Override
	public Review update(Review review) {
		return super.update(review);
	}

	@Override
	public Review get(Object reviewId) {
		return super.find(Review.class, reviewId);
	}

	@Override
	public void delete(Object reviewId) {

		super.delete(Review.class, reviewId);

	}

	@Override
	public List<Review> listAll() {
		return super.findWithNamedQuery("Review.listAll");
	}

	public Review findBySoda(Soda soda) {
		List<Review> listBySoda = super.findWithNamedQuery("Review.findBySoda", "soda_id", soda);
		if (listBySoda != null && listBySoda.size() > 0) {
			return listBySoda.get(0);
		}

		return null;
	}

	public List<Review> findByCustomerandSoda(Objects customerId, Objects sodaId) {

		Map<String, Objects> parameters = new HashMap();
		parameters.put("customerId", customerId);
		parameters.put("sodaId", sodaId);
		List<Review> reviews = super.findWithNamedQuery("Review.findByCustomerandSoda", null, parameters);
		return reviews;
	}

	public long countByCustomer(Object customerId) {

		return super.countQuery("Review.countByCustomer", "customerId", customerId);
	}

	
	
	@Override
	public long count() {
		return super.countQuery("Review.countAll");
	}
	
	
}
