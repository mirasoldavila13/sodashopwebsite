package com.sodashop.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.sodashop.entity.Soda;

public class SodaDAO extends JpaDAO<Soda> implements GenericDAO<Soda> {

	public SodaDAO(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Soda create(Soda soda) {
		soda.setLastUpdateTime(new Date());
		return super.create(soda);
	}

	@Override
	public Soda update(Soda soda) {
		soda.setLastUpdateTime(new Date());
		return super.update(soda);
	}

	@Override
	public Soda get(Object id) {
		return null;
	}

	@Override
	public void delete(Object sodaId) {
		super.delete(Soda.class, sodaId);
	}

	@Override
	public List<Soda> listAll() {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	
	
}