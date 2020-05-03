package com.sodashop.dao;

import static org.junit.Assert.*; 


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sodashop.entity.Category;
import com.sodashop.entity.Users;

public class CategoryDAOTest extends DaoTest {
	private static CategoryDAO categoryDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DaoTest.setUpBeforeClass();
		categoryDao = new CategoryDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DaoTest.tearDownAfterClass();
	}

	@Test
	public void testCreateCategory() {
		Category category = new Category("Soda");
		Category newCategory = categoryDao.create(category);
		
		assertTrue(category != null && category.getCategoryId() > 0);
	}
	
	@Test
	public void testUpdateCategory() {
		Category category = new Category("Club Soda");
		category.setCategoryId(7);
		category.setName("Club Soda");
		category = categoryDao.update(category);
		String expected = "Club Soda";
		String actual = category.getName();
		
		assertEquals(expected, actual);
	
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testListAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

}
