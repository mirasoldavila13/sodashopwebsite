package com.sodashop.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

		for(SodaOrder sodaOrder : listSodaOrder) {
			System.out.println(sodaOrder.getRecipientName() + " " + sodaOrder.getOrderId() + " " + sodaOrder.getPaymentMethod());
		}
		
		
		
		assertTrue(listSodaOrder.size() > 0);
	}
	
//	@Test
//	public void testCreateSodaOrder() {
//		SodaOrder order = new SodaOrder();
//		Customer customer = new Customer();
//		customer.setCustomerId(3120);
//		
//		order.setCustomer(customer);
//		order.setRecipientName("");
//		order.setRecipientPhone("");
//		order.setShippingAddress("");
//		
//		Set<OrderDetail> orderDetails = new HashSet<>();
//		OrderDetail orderDetail = new OrderDetail();
//		
//		Soda soda= new Soda();
//		orderDetail.setSoda(soda);
//		orderDetail.setQuantity(2);
//		orderDetail.setSubtotal(60.5f);
//		orderDetail.setSodaOrder(order);
//		soda.setSodaId(11);
//		
//		orderDetails.add(orderDetail);
//		
//		order.setOrderDetails(orderDetails);
//		
//		orderDAO.create(order);
		
//		assertTrue(order.getOrderId() > 0);
//		SodaOrder sodaOrder = new SodaOrder();
//		Customer customer = new Customer(); 
//		OrderDetailId orderDetailId = new OrderDetailId();
//		OrderDetail orderDetail = new OrderDetail();
//		Set<OrderDetailId> orderDetailIdSet = new HashSet<>();
//		
//		customer.setCustomerId(120);
//		customer.setEmail("email@email.com");
//		customer.setFullname("It's a Name");
//		customer.setAddress("123 Sesame Street");
//		customer.setCity("City");
//		customer.setCountry("Country");
//		customer.setPhone("999-999-9999");
//		customer.setZipcode("8888");
//		customer.setPassword("1234");
//		//customer.setRegisterDate(2020-04-03 00:00:00);
//		
//		sodaOrder.setCustomer(customer);
//		sodaOrder.setOrderDate(new Date());
//		sodaOrder.setRecipientName(customer.getFullname());
//		sodaOrder.setRecipientPhone(customer.getPhone());
//		sodaOrder.setShippingAddress(customer.getAddress());
//		sodaOrder.setOrderId(99);
//		sodaOrder.setStatus("shipped");
//		sodaOrder.setTotal(99.99f);
//		
//	
//
//		orderDetailId.setSodaId(2);
//		orderDetailId.setQuantity(80);
//		orderDetailId.setSubtotal(99.99f);
//		orderDetail.setSodaOrder(sodaOrder);
//		
//		Soda soda = new Soda();
//		soda.setSodaId(2);
//		
//		orderDetailIdSet.add(orderDetailId);
		
		//orderDetail2.se
		
//		Integer orderId = 215;
//		Date dateOrdered = new Date();
//		Integer quantity = 55;
//		Float subtotal = (float) 92.34;
//		Integer sodaId = 72;
//		
//		String shippingAddress = "123 Sesame Street";
//		String reciepientPhone = "987-654-321";
//		String reciepientName = "Duke Nukem";
//		String paymentMethod = "Monopoly Money";
//		String status = "shipped";
//		
//		Integer customerId = 23;
//		String email = "carbonation@tesla.org";
//		String city = "Imagination City";
//		String country = "Narnia";
//		String zipcode = "ABCDE";
//		String password = "1234";
				
//		
//		Customer customer = new Customer(email, reciepientName, shippingAddress, city, country, reciepientPhone, zipcode, password, dateOrdered);
//		SodaOrder sodaOrder = new SodaOrder(customer, dateOrdered, shippingAddress, reciepientName, reciepientPhone, paymentMethod, subtotal, status);
//		OrderDetailId orderDetailId = new OrderDetailId(orderId, dateOrdered, quantity, subtotal, sodaId);
//		OrderDetail orderDetail = new OrderDetail(orderDetailId, sodaOrder);
//		
//		OrderDetail newOrderDetail = orderDAO.create(orderDetail);
//		
//		assertTrue(orderDetail != null);
//		assertTrue(orderDetail.getSodaOrder().getRecipientName() == reciepientName);
//	}
	

	
}
