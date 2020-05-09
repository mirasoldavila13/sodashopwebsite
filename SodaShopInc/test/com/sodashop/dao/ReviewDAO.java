package com.sodashop.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sodashop.entity.Review;

public class ReviewDAO extends JpaDAO<Review> implements GenericDAO<Review> {

	@Override
	public Review create(Review review) {
		review.setReviewTime(new Date());
		return super.create(review);
	}

	@Override
	public Review update(Review review) {
		return super.update(review);
	}

	@Override
	public Review get(Object id) {
		return super.find(Review.class, id);

	}

	@Override
	public void delete(Object id) {
		super.delete(Review.class, id);
		
	}

	@Override
	public List<Review> listAll() {
		return super.findWithNamedQuery("Review.listAll");
		
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Review.countAll");

	}

	public Review findByCustomerAndSoda(Integer customerId, Integer sodaId) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("customerId", customerId);
		parameters.put("sodaId", sodaId);
		
		List<Review> result = super.findWithNamedQuery("Review.findByCustomerAndSoda", parameters);
		
		if (!result.isEmpty()) {
			return result.get(0);
		}
		
		return null;
	}
	
	public List<Review> listMostRecent() {
		return super.findWithNamedQuery("Review.listAll", 0, 3);
	}
	
	public long countByCustomer(int customerId) {
		return super.countWithNamedQuery("Review.countByCustomer", "customerId", customerId);
	}
}
