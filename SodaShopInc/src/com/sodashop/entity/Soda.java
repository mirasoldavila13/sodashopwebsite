package com.sodashop.entity;
// Generated Apr 27, 2020, 1:10:24 PM by Hibernate Tools 5.2.12.Final

import java.math.BigDecimal ;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Soda generated by hbm2java
 */
@Entity
@Table(name = "soda", catalog = "sodashopdb")
@NamedQueries({
//	@NamedQuery(name = "Soda.findAll", query = "SELECT s FROM Soda s"),
//	@NamedQuery(name = "Soda.findByName", query = "SELECT s FROM Soda s WHERE s.name = :name"),
//	@NamedQuery(name = "Soda.countAll", query = "SELECT COUNT(s) FROM Soda s"),
//	@NamedQuery(name = "Soda.countByCategory", query = "SELECT COUNT(s) FROM Soda s WHERE s.category.categoryId = :catId"),
//	@NamedQuery(name = "Soda.findByCategory", query = "SELECT s FROM Soda s JOIN " + "Category c ON s.category.categoryId = c.categoryId AND c.categoryId = :catId"),
//	@NamedQuery(name = "Soda.listNew", query = "SELECT s FROM Soda s  ORDER BY s.publishDate DESC"),
//	@NamedQuery(name = "Soda.search", query = "SELECT s FROM Soda s WHERE s.name LIKE '%' :keyword '%'"
//			+ " OR s.manufactor LIKE '%' :keyword '%'"
//			+ " OR s.description LIKE '%' :keyword '%'")
})


public class Soda implements java.io.Serializable {

	private Integer sodaId;
	private String sodaName;
	private String description;
	private BigDecimal quantityInStock;
	private BigDecimal amountHeld;
	private String stockUnits;
	private Float price;
	private String manufacturer;
	private Date lastUpdateTime;
	private Integer categoryId;
	private Set<Review> reviews = new HashSet<Review>(0);

	public Soda() {
	}

	public Soda(String sodaName, String description, BigDecimal quantityInStock, BigDecimal amountHeld,
			String stockUnits, Float price, String manufacturer, Date lastUpdateTime, Integer categoryId,
			Set<Review> reviews) {
		this.sodaName = sodaName;
		this.description = description;
		this.quantityInStock = quantityInStock;
		this.amountHeld = amountHeld;
		this.stockUnits = stockUnits;
		this.price = price;
		this.manufacturer = manufacturer;
		this.lastUpdateTime = lastUpdateTime;
		this.categoryId = categoryId;
		this.reviews = reviews;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "soda_id", unique = true, nullable = false)
	public Integer getSodaId() {
		return this.sodaId;
	}

	public void setSodaId(Integer sodaId) {
		this.sodaId = sodaId;
	}

	@Column(name = "soda_name", length = 50)
	public String getSodaName() {
		return this.sodaName;
	}

	public void setSodaName(String sodaName) {
		this.sodaName = sodaName;
	}

	@Column(name = "description", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "quantity_in_stock", precision = 10)
	public BigDecimal getQuantityInStock() {
		return this.quantityInStock;
	}

	public void setQuantityInStock(BigDecimal quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	@Column(name = "amount_held", precision = 10)
	public BigDecimal getAmountHeld() {
		return this.amountHeld;
	}

	public void setAmountHeld(BigDecimal amountHeld) {
		this.amountHeld = amountHeld;
	}

	@Column(name = "stock_units", length = 15)
	public String getStockUnits() {
		return this.stockUnits;
	}

	public void setStockUnits(String stockUnits) {
		this.stockUnits = stockUnits;
	}

	@Column(name = "price", precision = 10)
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Column(name = "manufacturer", length = 50)
	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update_time", length = 19)
	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Column(name = "category_id")
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "soda")
	public Set<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

}
