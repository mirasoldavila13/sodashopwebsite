package com.sodashop.entity;
// Generated May 5, 2020, 5:38:19 PM by Hibernate Tools 5.2.12.Final

import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Review generated by hbm2java
 */
@Entity
@Table(name = "review", catalog = "sodashopdb")
@NamedQueries({
	@NamedQuery(name = "Review.listAll", query = "SELECT r FROM Review r ORDER BY r.reviewTime DESC"),
	@NamedQuery(name = "Review.countAll", query = "SELECT COUNT(r) FROM Review r"),
	@NamedQuery(name = "Review.findByCustomerAndSoda",  query = "SELECT r FROM Review r WHERE r.customer.customerId =:customerId" + " AND r.soda.sodaId =:sodaId"),
	@NamedQuery(name = "Review.mostFavoredSodas", query = "SELECT r.soda, COUNT(r.soda.sodaId) AS ReviewCount, AVG(r.rating) as AvgRating FROM Review r " + "GROUP BY r.soda.sodaId HAVING AVG(r.rating) >= 4.0 " + "ORDER BY ReviewCount DESC, AvgRating DESC"),
	@NamedQuery(name = "Review.countByCustomer", query = "SELECT COUNT(r.reviewId) FROM Review r WHERE r.customer.customerId =:customerId")
})
public class Review implements java.io.Serializable {

	private Integer reviewId;
	private Customer customer;
	private Soda soda;
	private int rating;
	private String headline;
	private String comment;
	private Date reviewTime;

	public Review() {
	}

	public Review(Customer customer, Soda soda, int rating, String headline, String comment, Date reviewTime) {
		this.customer = customer;
		this.soda = soda;
		this.rating = rating;
		this.headline = headline;
		this.comment = comment;
		this.reviewTime = reviewTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "review_id", unique = true, nullable = false)
	public Integer getReviewId() {
		return this.reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "soda_id", nullable = false)
	public Soda getSoda() {
		return this.soda;
	}

	public void setSoda(Soda soda) {
		this.soda = soda;
	}

	@Column(name = "rating", nullable = false)
	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Column(name = "headline", nullable = false, length = 128)
	public String getHeadline() {
		return this.headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	@Column(name = "comment", nullable = false, length = 500)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "review_time", nullable = false, length = 19)
	public Date getReviewTime() {
		return this.reviewTime;
	}

	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}

}
