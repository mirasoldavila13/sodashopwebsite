package com.sodashop.dao;

import static org.junit.Assert.*;

import java.util.List;

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
		
		Category newCategory = categoryDao.update(category);
		
		assertEquals(category.getName(), newCategory.getName());
	
	}

	@Test
	public void testGet() {
		Integer categoryId = 7;
		Category category = categoryDao.get(categoryId);
		assertNotNull(category);
		
		
	}

	@Test
	public void testDeleteCategoryt() {
		Integer categoryId = 9;
		categoryDao.delete(categoryId);
		Category category = categoryDao.get(categoryId);
		//we use assertNull, it doesn't exist once it gets deleted from sodashopdb
		assertNull(category);
	}

	@Test
	public void testListAll() {
		List<Category> listCategory = categoryDao.listAll();
		//if you want to see it actually print 
		for(Category category: listCategory) {
			System.out.println(category.getName());
		}
		assertTrue(listCategory.size() > 0);
		
		
		
	}

	@Test
	public void testCount() {
		long totalCategories = categoryDao.count();
		/*this test is test to see if I have 7 soda categories in the db  with the total users
		 * when you do this test please refer to how many rows/users you have
		 * */
		assertEquals(7,totalCategories);
	}
	
	@Test
	public void testFindCategory() {
		String name = "Ice Cream Sundae";
		Category category = categoryDao.findByName(name);
		assertNotNull(category);	
	}
	@Test
	public void testFindNotCategory() {
		Integer categoryId = 99;
		Category category = categoryDao.get(categoryId);
		
		assertNull(category);
	}

}
