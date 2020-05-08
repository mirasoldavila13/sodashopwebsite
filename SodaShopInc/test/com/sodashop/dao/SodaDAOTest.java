package com.sodashop.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sodashop.entity.Category;
import com.sodashop.entity.Soda;
import com.sodashop.entity.Users;

public class SodaDAOTest extends DaoTest{
	private static SodaDAO sodaDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DaoTest.setUpBeforeClass();
		sodaDAO = new SodaDAO(entityManager);

	}

	@Test
	public void testUpdateSoda() throws ParseException, IOException {
		Soda existSoda = new Soda();
		existSoda.setSodaId(20);
		
		
		Category category = new Category("Test");
		category.setCategoryId(7);
		existSoda.setCategory(category);
		
		existSoda.setName("Poopy");
		existSoda.setDescription("Crisp refreshing citrus drink");
		
		String imagePath = "/Users/mirasoldavila/Desktop/sodaitem.png";
		
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		existSoda.setImage(imageBytes);
		
		existSoda.setPrice(50.99f);
		
//		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//		Date publishDate = dateFormat.parse("04/01/2020");
//		existSoda.setPublishDate(publishDate);
		
		existSoda.setManufacture("Spacies");
		Soda updateSoda = sodaDAO.update(existSoda);
		
//		assertEquals(existSoda.getCategory().getCategoryId(), updateSoda.getCategory().getCategoryId());
		
		assertEquals(updateSoda.getName(), "Poopy");
	
	}

	@Test
	public void testCreateSoda() throws ParseException, IOException {
		Soda newSoda = new Soda();
		
		
		Category category = new Category("Fruity");
		category.setCategoryId(4);
		newSoda.setCategory(category);
		
		newSoda.setName("New");
		newSoda.setDescription("Crisp refreshing citrus drink");
		
		String imagePath = "/Users/mirasoldavila/Desktop/sodaitem.png";
		
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newSoda.setImage(imageBytes);
		
		newSoda.setPrice(5.99f);
		
//		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//		Date publishDate = dateFormat.parse("04/01/2020");
//		newSoda.setPublishDate(publishDate);
		
		newSoda.setManufacture("Spacies");
		Soda createSoda = sodaDAO.create(newSoda);
	
		
		assertTrue(createSoda.getSodaId() > 0);
	
	}
	
	@Test
	public void testDeleteSuccess() {
		Integer sodaId = 23;
		sodaDAO.delete(sodaId);
	}


	@Test
	public void testListAll() {
		List<Soda> listSoda = sodaDAO.listAll();
		
		for(Soda s: listSoda) {
			System.out.println(s.getName() + "- " + s.getManufacture());
		}
		assertFalse(listSoda.isEmpty());
	}
	
	@Test
	public void testFindByName() {
		String name = "Cap'n Grapeful";
		Soda soda = sodaDAO.findByName(name);
		
		assertNotNull(soda);
	}
	
	@Test
	public void testListNewSoda() {
		List<Soda> listNewSoda = sodaDAO.listNewSoda();
		for (Soda soda : listNewSoda) {
			System.out.println(soda.getName() + " - " + soda.getLastUpdateTime());
		}
		assertEquals(4, listNewSoda.size());
	}
	
	@Test
	public void testListByCategory() {
		int categoryId = 4;
		
		List<Soda> listSoda = sodaDAO.listByCategory(categoryId);
		for(Soda s: listSoda) {
			System.out.println(s.getName() + " " + s.getCategory().getCategoryId());
		}
		assertTrue(listSoda.size() > 0);
	}
	@Test
	public void testCount() {
		long totalSodas = sodaDAO.count();
		assertEquals(17, totalSodas);
	}
	
	@Test
	public void testGetSodaSuccess() {
		Integer sodaId = 2;
		Soda soda = sodaDAO.get(sodaId);
		assertNotNull(soda);
	}
	
	

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DaoTest.tearDownAfterClass();
	}

}
