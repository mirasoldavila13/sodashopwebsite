package com.sodashop.entity;
// Generated May 7, 2020, 1:56:56 AM by Hibernate Tools 5.2.12.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "order_detail", catalog = "sodashopdb")
//@NamedQueries({
//@NamedQuery(name = "OrderDetail.bestSelling", query = "SELECT o.soda FROM OrderDetail o GROUP by o.soda.sodaId " + "ORDER BY Sum(o.quantity) DESC"),
//@NamedQuery(name = "OrderDetail.countBySoda", query = "SELECT Count(*) FROM OrderDetail o WHERE od.soda.sodaId =:sodaId")	
//})
public class OrderDetail implements java.io.Serializable {

	private OrderDetailId id;
	private Soda soda;
	private SodaOrder sodaOrder;

	public OrderDetail() {
	}

	public OrderDetail(OrderDetailId id) {
		this.id = id;
	}

	public OrderDetail(OrderDetailId id, Soda soda, SodaOrder sodaOrder) {
		this.id = id;
		this.soda = soda;
		this.sodaOrder = sodaOrder;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "orderId", column = @Column(name = "order_id")),
			@AttributeOverride(name = "sodaId", column = @Column(name = "soda_id")),
			@AttributeOverride(name = "quantity", column = @Column(name = "quantity", nullable = false)),
			@AttributeOverride(name = "subtotal", column = @Column(name = "subtotal", nullable = false, precision = 12, scale = 0)) })
	public OrderDetailId getId() {
		return this.id;
	}

	public void setId(OrderDetailId id) {
		this.id = id;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "soda_id", insertable = false, updatable = false)
	public Soda getSoda() {
		return this.soda;
	}

	public void setSoda(Soda soda) {
		this.soda = soda;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", insertable = false, updatable = false)
	public SodaOrder getSodaOrder() {
		return this.sodaOrder;
	}

	public void setSodaOrder(SodaOrder sodaOrder) {
		this.sodaOrder = sodaOrder;
	}

}
