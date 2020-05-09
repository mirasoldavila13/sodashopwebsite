package com.sodashop.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.sodashop.entity.SodaOrder;

public class OrderDAO extends JpaDAO<SodaOrder> implements GenericDAO<SodaOrder> {

	public OrderDAO() {
	}

	@Override
	public SodaOrder create(SodaOrder order) {
		order.setOrderDate(new Date());		
		order.setStatus("Processing");
		
		return super.create(order);
	}

	@Override
	public SodaOrder update(SodaOrder order) {
		return super.update(order);

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
		return super.countWithNamedQuery("SodaOrder.countAll");

	}
	public List<SodaOrder> listByCustomer(Integer customerId) {
		return super.findWithNamedQuery("SodaOrder.findByCustomer", 
				"customerId", customerId);
	}
	
	public List<SodaOrder> listMostRecentSales() {
		return super.findWithNamedQuery("SodaOrder.findAll", 0, 3);
	}

	public long countOrderDetailByBook(int sodaId) {
		return super.countWithNamedQuery("OrderDetail.countByBook", "sodaId", sodaId);
	}
	
	public long countByCustomer(int customerId) {
		return super.countWithNamedQuery("SodaOrder.countByCustomer", "customerId", customerId);
	}

}
