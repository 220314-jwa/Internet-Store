package com.synergy.ecommerce.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "Category", uniqueConstraints = {
	@UniqueConstraint(name = "category_id_unique", columnNames = "category_id")
})
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id", updatable = false)
	private Long id;
	
	@Column(name = "name", nullable = false, columnDefinition = "TEXT")
	private String name;
	
	@Column(name = "description", nullable = false, columnDefinition = "TEXT")
	private String description;
	
	// @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	/*@OneToMany
	 @JoinColumn(name = "product_id")
	@JsonManagedReference
	 private List<Product>  products = new ArrayList<>();
	 */
	public Category(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public Category() {
		
		
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	/*public List<Product> getProducts() {
		return products;
	}

	public void setProduct(List<Product> products) {
		this.products = products;
	}*/

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
