package com.sodashop.entity;
// Generated May 5, 2020, 5:38:19 PM by Hibernate Tools 5.2.12.Final

import java.math.BigDecimal;
import java.util.Base64;
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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "soda", catalog = "sodashopdb", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@NamedQueries({
	@NamedQuery(name = "Soda.findAll", query = "SELECT s from Soda s"),
	@NamedQuery(name = "Soda.findByName", query = "SELECT s from Soda s where s.name = :name"),
	@NamedQuery(name = "Soda.countAll", query = "SELECT COUNT(*) from Soda s "),
	@NamedQuery(name = "Soda.findByCategory", query = "SELECT s FROM Soda s JOIN " + "Category c ON s.category.categoryId = c.categoryId AND c.categoryId = :catId"),
})
public class Soda implements java.io.Serializable {

	private Integer sodaId;
	private Category category;
	private String name;
	private String description;
	private byte[] image;
	private String base64Image;
	private float price;
	private Date lastUpdateTime;
	private BigDecimal quantityInStock;
	private BigDecimal amountHeld;
	private String stockUnits;
	private String manufacture;
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);
	private Set<Review> reviews = new HashSet<Review>(0);

	public Soda() {
	}

	public Soda(Category category, String name, String description, byte[] image, float price, Date lastUpdateTime, String manufactor) {
		this.category = category;
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.lastUpdateTime = lastUpdateTime;
		this.manufacture = manufactor;
	}

	public Soda(Category category, String name, String description, byte[] image, float price, 
			Date lastUpdateTime, BigDecimal quantityInStock, BigDecimal amountHeld, String stockUnits,
			String manufacture, Set<OrderDetail> orderDetails, Set<Review> reviews) {
		this.category = category;
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.lastUpdateTime = lastUpdateTime;
		this.quantityInStock = quantityInStock;
		this.amountHeld = amountHeld;
		this.stockUnits = stockUnits;
		this.manufacture = manufacture;
		this.orderDetails = orderDetails;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "name", unique = true, nullable = false, length = 128)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", nullable = false, length = 16777215)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "image", nullable = false)
	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Column(name = "price", nullable = false, precision = 12, scale = 0)
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}



	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update_time", nullable = false, length = 19)
	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
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

	@Column(name = "manufacture", nullable = false, length = 64)
	public String getManufacture() {
		return this.manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "soda")
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "soda")
	public Set<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	@Transient
	public String getBase64Image() {
		this.base64Image = Base64.getEncoder().encodeToString(this.image);
		return this.base64Image;
	}
	@Transient
	public void setBased64Image(String base64Image) {
		this.base64Image = base64Image;
	}
}
