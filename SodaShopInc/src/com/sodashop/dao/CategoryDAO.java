package com.sodashop.dao;

import java.util.List; 

import javax.persistence.EntityManager;
import com.sodashop.entity.Category;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {
	
	
	public CategoryDAO(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Category create(Category category) {
		return super.create(category);
	}

	@Override
	public Category update(Category category) {
		return super.update(category);
	}

	@Override
	public Category get(Object id) {
		return super.find(Category.class, id);
	}

	@Override
	public void delete(Object id) {
		
	}

	@Override
	public List<Category> listAll() {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}



	

}
