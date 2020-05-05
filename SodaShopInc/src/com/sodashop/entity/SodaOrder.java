package com.sodashop.entity;
// Generated Apr 27, 2020, 1:10:24 PM by Hibernate Tools 5.2.12.Final

import java.util.Date; 
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "soda_order", catalog = "sodashopdb")
<<<<<<< HEAD

@NamedQueries({
	@NamedQuery(name = "SodaOrder.findAll", query = "SELECT so FROM SodaOrder so ORDER BY so.orderDate DESC"),
	@NamedQuery(name = "SodaOrder.countAll", query = "SELECT COUNT(so) FROM SodaOrder so"),
	@NamedQuery(name = "SodaOrder.findByCustomer",  query = "SELECT so FROM SodaOrder so WHERE so.customer.customerId =:customerId ORDER BY so.orderDate DESC"),
	@NamedQuery(name = "SodaOrder.findByIdAndCustomer",
			query = "SELECT so FROM SodaOrder so WHERE so.orderId =:orderId AND so.customer.customerId =:customerId"),
	@NamedQuery(name = "SodaOrder.countByCustomer",
			query = "SELECT COUNT(so.orderId) FROM SodaOrder so WHERE so.customer.customerId =:customerId")
})
=======
//@NamedQueries({
//	@NamedQuery(name = "SodaOrder.findAll", query = "SELECT so FROM SodaOrder so ORDER BY so.orderDate DESC"),
//	@NamedQuery(name = "SodaOrder.countAll", query = "SELECT COUNT(*) FROM SodaOrder"),
//	@NamedQuery(name = "SodaOrder.findByCustomer",  query = "SELECT so FROM SoOrder so WHERE so.customer.customerId =:customerId ORDER BY so.orderDate DESC"),
//	@NamedQuery(name = "SodaOrder.findByIdAndCustomer", query = "SELECT so FROM SodaOrder so WHERE so.orderId =:orderId AND so.customer.customerId =:customerId"),
//	@NamedQuery(name = "Soda.findByCategory", query = "SELECT s FROM Soda s JOIN " + "Category c ON b.category.categoryId = c.categoryId AND c.categoryId = :catId"),
//	@NamedQuery(name = "SodaOrder.countByCustomer", query = "SELECT COUNT(so.orderId) FROM SodaOrder so WHERE so.customer.customerId =:customerId")
//	
//})
>>>>>>> adminLogin

public class SodaOrder implements java.io.Serializable {

	private Integer orderId;
	private Customer customer;
	private Date orderDate;
	private String shippingAddress;
	private String recipientName;
	private String recipientPhone;
	private String paymentMethod;
	private float total;
	private String status;
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

	public SodaOrder() {
	}

	public SodaOrder(Customer customer, Date orderDate, String shippingAddress, String recipientName,
			String recipientPhone, String paymentMethod, float total, String status) {
		this.customer = customer;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
		this.paymentMethod = paymentMethod;
		this.total = total;
		this.status = status;
	}

	public SodaOrder(Customer customer, Date orderDate, String shippingAddress, String recipientName,
			String recipientPhone, String paymentMethod, float total, String status, Set<OrderDetail> orderDetails) {
		this.customer = customer;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
		this.paymentMethod = paymentMethod;
		this.total = total;
		this.status = status;
		this.orderDetails = orderDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "order_id", unique = true, nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_date", nullable = false, length = 19)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name = "shipping_address", nullable = false, length = 256)
	public String getShippingAddress() {
		return this.shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Column(name = "recipient_name", nullable = false, length = 30)
	public String getRecipientName() {
		return this.recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	@Column(name = "recipient_phone", nullable = false, length = 15)
	public String getRecipientPhone() {
		return this.recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	@Column(name = "payment_method", nullable = false, length = 20)
	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Column(name = "total", nullable = false, precision = 12, scale = 0)
	public float getTotal() {
		return this.total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Column(name = "status", nullable = false, length = 20)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sodaOrder")
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
