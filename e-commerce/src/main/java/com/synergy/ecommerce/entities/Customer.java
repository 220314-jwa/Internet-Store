package com.synergy.ecommerce.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customer", uniqueConstraints = {
		@UniqueConstraint(name = "customer_email_unique", columnNames = "email"),
		@UniqueConstraint(name = "customer_phone_number_unique", columnNames = "phone_number"),
		@UniqueConstraint(name = "customer_username_unique", columnNames = "username") })
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long id;

	@Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
	private String firstName;

	@Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
	private String lastName;

	@Column(name = "email", nullable = false, columnDefinition = "TEXT")
	private String email;

	@Column(name = "address", nullable = false, columnDefinition = "TEXT")
	private String address;

	@Column(name = "phone_number", nullable = false)
	private Long phoneNumber;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "username", nullable = false)
	private String username;

	@OneToMany(mappedBy = "customer")
	@JsonManagedReference
	private List<Order> orders;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_cart", 
      joinColumns = 
        {@JoinColumn(name = "customer_id",referencedColumnName="customer_id") },
      inverseJoinColumns = 
        {@JoinColumn(name = "id",referencedColumnName="id") })
    private Cart cart;

	public Customer() {
	}


	public Customer(Long id, String firstName, String lastName, String email, String address, Long phoneNumber,
			String password, String username, List<Order> orders) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.username = username;
		this.orders = orders;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", password=" + password + ", username="
				+ username + "]";
	}

}
