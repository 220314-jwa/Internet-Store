package com.synergy.ecommerce.entities;

import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Image {
	@Id
    @GeneratedValue
    Long id;
	
	@Lob
    byte[] content;
	
	String name;
	
	String location;

	
	public Image() {
		super();
	}


	public Image(String name, String location) {
		this.name = name;
		this.location = location;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public byte[] getContent() {
		return content;
	}


	public void setContent(byte[] content) {
		this.content = content;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(content);
		result = prime * result + Objects.hash(id, location, name);
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
		Image other = (Image) obj;
		return Arrays.equals(content, other.content) && Objects.equals(id, other.id)
				&& Objects.equals(location, other.location) && Objects.equals(name, other.name);
	}


	@Override
	public String toString() {
		return "Image [id=" + id + ", content=" + Arrays.toString(content) + ", name=" + name + ", location=" + location
				+ "]";
	}
	
	
	
	
}
