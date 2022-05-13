package com.synergy.ecommerce.entities;


import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name = "cart", uniqueConstraints = {
		@UniqueConstraint(name = "cart_id_unique", columnNames = "cart_id")
	
		})
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id", updatable = false)
	private Long id;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@Column(name = "total_cost", nullable = false)
	private double totalcost;
	
	@OneToOne(mappedBy = "cart")
	private Customer customer;


	@OneToMany(mappedBy = "cart")
	@JsonIgnore
	private List<Product> products;
	public Cart() {}
	


	public Cart(Long id, int quantity, double totalcost, Customer customer, List<Product> products) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.totalcost = totalcost;
		this.customer = customer;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer, id, products, quantity, totalcost);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(id, other.id)
				&& Objects.equals(products, other.products) && quantity == other.quantity
				&& Double.doubleToLongBits(totalcost) == Double.doubleToLongBits(other.totalcost);
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", quantity=" + quantity + ", totalcost=" + totalcost + ", customer=" + customer
				+ "]";
	}
	

}
