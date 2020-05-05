package com.sodashop.entity;
// Generated Apr 27, 2020, 1:10:24 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
<<<<<<< HEAD
@Table(name = "order_detail", catalog = "bookstoredb")
@NamedQueries({
	
})
=======
@Table(name = "order_detail", catalog = "sodashopdb")
//@NamedQueries({
//	@NamedQuery(name = "OrderDetail.bestSelling", query = "SELECT o.soda FROM OrderDetail o GROUP by o.soda.sodaId " + "ORDER BY SUM(o.quantity) DESC"),
//	@NamedQuery(name = "OrderDetail.countBySoda", query = "SELECT COUNT(*) FROM OrderDetail o WHERE od.soda.sodaId =:sodaId")	
//})
>>>>>>> adminLogin
public class OrderDetail implements java.io.Serializable {

	private OrderDetailId id;
	private SodaOrder sodaOrder;

	public OrderDetail() {
	}

	public OrderDetail(OrderDetailId id) {
		this.id = id;
	}

	public OrderDetail(OrderDetailId id, SodaOrder sodaOrder) {
		this.id = id;
		this.sodaOrder = sodaOrder;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "orderId", column = @Column(name = "order_id")),
			@AttributeOverride(name = "dateOrdered", column = @Column(name = "date_ordered", nullable = false, length = 10)),
			@AttributeOverride(name = "quantity", column = @Column(name = "quantity")),
			@AttributeOverride(name = "subtotal", column = @Column(name = "subtotal", precision = 12, scale = 0)),
			@AttributeOverride(name = "sodaId", column = @Column(name = "soda_id")) })
	public OrderDetailId getId() {
		return this.id;
	}

	public void setId(OrderDetailId id) {
		this.id = id;
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
