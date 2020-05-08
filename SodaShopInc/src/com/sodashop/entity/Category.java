package com.sodashop.entity;

// Generated May 7, 2020, 1:56:56 AM by Hibernate Tools 5.2.12.Final


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "category", catalog = "sodashopdb")
public class Category implements java.io.Serializable {

	private Integer categoryId;
	private String name;
	private Set<Soda> sodas = new HashSet<Soda>(0);

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public Category(String name, Set<Soda> sodas) {
		this.name = name;
		this.sodas = sodas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "category_id", unique = true, nullable = false)
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "name", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Soda> getSodas() {
		return this.sodas;
	}

	public void setSodas(Set<Soda> sodas) {
		this.sodas = sodas;
	}

}
