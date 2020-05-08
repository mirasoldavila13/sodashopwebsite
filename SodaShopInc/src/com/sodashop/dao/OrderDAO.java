package com.sodashop.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.sodashop.entity.Category;
import com.sodashop.entity.OrderDetail;
import com.sodashop.entity.SodaOrder;

public class OrderDAO extends JpaDAO<SodaOrder> implements GenericDAO<SodaOrder> {

	public OrderDAO(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public SodaOrder get(Object id) {
		return super.find(SodaOrder.class, id);
	}

	@Override
	public void delete(Object id) {
		 super.delete(SodaOrder.class, id);
	}

	@Override
	public List<SodaOrder> listAll() {
		return super.findWithNamedQuery("SodaOrder.findAll");
	}


	@Override
	public long count() {
		return super.countQuery("SodaOrder.countBySoda");
	}

	@Override
	public SodaOrder create(SodaOrder sodaOrder) {
		sodaOrder.setOrderDate(new Date());
		return super.create(sodaOrder);
	}
	
//	public SodaOrder get(Integer orderId, Integer customerId) {
//		Map<String, Object> parameters = new HashMap<>();
//		parameters.put("orderId", orderId);
//		parameters.put("customerId", customerId);
//		
//		List<SodaOrder> result = super.findWithNamedQuery("SodaOrder.findByIdAndCustomer", parameters );
//		
//		if (!result.isEmpty()) {
//			return result.get(0);
//		}
//		return null;
//	}

}
