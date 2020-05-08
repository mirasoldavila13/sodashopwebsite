package com.sodashop.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sodashop.entity.Customer;
import com.sodashop.entity.OrderDetail;
import com.sodashop.entity.OrderDetailId;
import com.sodashop.entity.Soda;
import com.sodashop.entity.SodaOrder;

public class OrderDAOTest extends DaoTest {

	private static OrderDAO orderDAO;
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		DaoTest.setUpBeforeClass();
		orderDAO = new OrderDAO(entityManager);

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DaoTest.tearDownAfterClass();
	}
	
	@Test
	public void testListAll() {
		List<SodaOrder> listSodaOrder = orderDAO.listAll();

		System.out.println("testListAll()");
		
		for(SodaOrder sodaOrder : listSodaOrder) {
			System.out.println(sodaOrder.getRecipientName() + " " + sodaOrder.getOrderId() + " " + sodaOrder.getPaymentMethod());
		}
		
		
		
		assertTrue(listSodaOrder.size() > 0);
	}
	
	@Test
	public void testFindByOrderId() {
		List<SodaOrder> listSodaOrder = orderDAO.findWithNamedQuery("SodaOrder.findByOrderId", "id", 98);
		
		System.out.println("testFindByOrderId()");
		
		for(SodaOrder sodaOrder : listSodaOrder) {
			System.out.println(sodaOrder.getRecipientName() + " " + sodaOrder.getOrderId() + " " + sodaOrder.getPaymentMethod());
		}
				
		assertTrue(listSodaOrder.get(0).getOrderId() == 98);
	}
	
	@Test
	public void testFindByCustomerId() {
		List<SodaOrder> listSodaOrder = orderDAO.findWithNamedQuery("SodaOrder.findByCustomerId", "id", 126);
		
		System.out.println("testFindByCustomerId()");
		
		for(SodaOrder sodaOrder : listSodaOrder) {
			System.out.println(sodaOrder.getRecipientName() + " " + sodaOrder.getOrderId() + " " + sodaOrder.getPaymentMethod() + " " 
					+ sodaOrder.getCustomer().getCity());
		}
				
		assertTrue(listSodaOrder.get(0).getCustomer().getCustomerId() == 126);
	}
	
	@Test
	public void testFindAllByCustomerId() {
		List<SodaOrder> listSodaOrder = orderDAO.findWithNamedQuery("SodaOrder.findAllByCustomerId", "id", 120);
		
		System.out.println("testFindAllByCustomerId()");
		
		for(SodaOrder sodaOrder : listSodaOrder) {
			System.out.println(sodaOrder.getRecipientName() + " " + sodaOrder.getOrderId() + " " + sodaOrder.getPaymentMethod() + " " 
					+ sodaOrder.getCustomer().getCity());
		}
		
		List<OrderDetail> arrayList = new ArrayList<OrderDetail>(listSodaOrder.get(0).getOrderDetails());
		
		Float test = (float) 92.8;
				
		assertTrue(arrayList.get(0).getId().getSubtotal() == test);
	}
	
//	@Test
//	public void testCreateSodaOrder() {
//		SodaOrder sodaOrder = new SodaOrder();
//		OrderDetail orderDetail = new OrderDetail();
//		OrderDetailId orderDetailId = new OrderDetailId();
//		Set<OrderDetail> orderDetailSet = new HashSet<>();
//		Customer customer = new Customer();
//		
//		customer.setCustomerId(987);
//		customer.setEmail("email7@email.com");
//		customer.setFullname("Dora the Explorer");
//		customer.setAddress("The Vast Wilderness");
//		customer.setCity("City");
//		customer.setCountry("Country");
//		customer.setPhone("888-888-88888");
//		customer.setZipcode("1234");
//		customer.setPassword("1234");
//		customer.setRegisterDate(new Date());
//		
//		orderDetailId.setOrderId(215);
//		orderDetailId.setQuantity(80);
//		orderDetailId.setSodaId(11);
//		orderDetailId.setSubtotal(98.50f);
//		
//		orderDetail.setId(orderDetailId);
//		orderDetail.setSodaOrder(sodaOrder);
//		
//		orderDetailSet.add(orderDetail);
//		
//		sodaOrder.setOrderId(215);
//		sodaOrder.setCustomer(customer);
//		//sodaOrder.setOrderDate(new Date());
//		sodaOrder.setOrderDetails(orderDetailSet);
//		sodaOrder.setPaymentMethod("Venmo");
//		sodaOrder.setRecipientName(customer.getFullname());
//		sodaOrder.setShippingAddress(customer.getAddress());
//		sodaOrder.setTotal(orderDetailId.getSubtotal());
//		sodaOrder.setStatus("shipped");
//		sodaOrder.setRecipientPhone(customer.getPhone());
//		
//		SodaOrder createSodaOrder = orderDAO.create(sodaOrder);
//		
//		
//		assertTrue(createSodaOrder.getPaymentMethod() == "Venmo");	
//		
//	}
	

	
}
