package com.synergy.ecommerce.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "product", uniqueConstraints = {
		@UniqueConstraint(name = "product_code_unique", columnNames = "code")
		})
public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false)
	private Long id;
	
	@Column(name = "name", nullable = false, columnDefinition = "TEXT")
	private String name;
	
	@Column(name = "price", nullable = false)
	private Double price;
	
	@Column(name = "code", nullable = false, columnDefinition = "TEXT")
	private String code;
	
	@Column(name = "prodDate", nullable = false)
	private Date prodDate;
	
	
	 @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "category_id")
	 @JsonBackReference
	    private Category category;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Date getProdDate() {
		return prodDate;
	}


	public void setProdDate(Date prodDate) {
		this.prodDate = prodDate;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public int hashCode() {
		return Objects.hash(category, code, id, name, price, prodDate);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && Objects.equals(code, other.code)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price) && Objects.equals(prodDate, other.prodDate);
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", code=" + code + ", prodDate=" + prodDate
				+ ", category=" + category + "]";
	}


	public boolean deleteProduct() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
