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
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = dateFormat.parse("04/01/2020");
		existSoda.setPublishDate(publishDate);
		
		existSoda.setManufactor("Spacies");
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
		
		newSoda.setName("Cali Poopy");
		newSoda.setDescription("Crisp refreshing citrus drink");
		
		String imagePath = "/Users/mirasoldavila/Desktop/sodaitem.png";
		
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newSoda.setImage(imageBytes);
		
		newSoda.setPrice(5.99f);
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = dateFormat.parse("04/01/2020");
		newSoda.setPublishDate(publishDate);
		
		newSoda.setManufactor("Spacies");
		Soda createSoda = sodaDAO.create(newSoda);
	
		
		assertTrue(createSoda.getSodaId() > 0);
	
	}


	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DaoTest.tearDownAfterClass();
	}

}
