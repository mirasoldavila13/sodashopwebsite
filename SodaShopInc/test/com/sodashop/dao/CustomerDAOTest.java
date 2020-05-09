package com.sodashop.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sodashop.entity.Customer;

public class CustomerDAOTest {

private static CustomerDAO customerDao; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customerDao = new CustomerDAO();
	}

	

	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setEmail("James.j@gmail.com");
		customer.setFullname("James Cortez");
		customer.setCity("New York");
		customer.setCountry("United States");
		customer.setAddress("123 West Avenue");
		customer.setPassword("lol");
		customer.setPhone("183342230");
		customer.setZipcode("123221");
		
		Customer savedCustomer = customerDao.create(customer);
		
		assertTrue(savedCustomer.getCustomerId() > 0);
	}

	@Test
	public void testGet() {
		Integer customerId = 1;
		Customer customer = customerDao.get(customerId);
		
		assertNotNull(customer);
	}
	
	@Test
	public void testUpdateCustomer() {
		Customer customer = customerDao.get(1);
		String fullName = "Tom The Cat";
		customer.setFullname(fullName);
		
		Customer updatedCustomer = customerDao.update(customer);
		
		assertTrue(updatedCustomer.getFullname().equals(fullName));
	}

	@Test
	public void testDeleteCustomer() {
		Integer customerId = 1;
		customerDao.delete(customerId);
		Customer customer = customerDao.get(1);
		
		assertNull(customer);		
		
	}

	@Test
	public void testListAll() {
		List<Customer> listCustomers = customerDao.listAll();
		
		for (Customer customer : listCustomers) {
			System.out.println(customer.getFullname());
		}
		
		assertFalse(listCustomers.isEmpty());
	}
	
	@Test
	public void testCount() {
		long totalCustomers = customerDao.count();
		
		assertEquals(4, totalCustomers);
		
	}
	
	@Test
	public void testFindByEmail() {
		String email = "email5@email.com";
		Customer customer = customerDao.findByEmail(email);
		
		assertNotNull(customer);
		
	}

	@Test
	public void testCheckLoginSuccess() {
		String email = "email4@email.com";
		String password = "1234";
		
		Customer customer = customerDao.checkLogin(email, password);
		
		assertNotNull(customer);
		
	}
	
	@Test
	public void testCheckLoginFail() {
		String email = "email4@email.com";
		String password = "secret";
		
		Customer customer = customerDao.checkLogin(email, password);
		
		assertNull(customer);
		
	}	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		customerDao.close();
	}
}
