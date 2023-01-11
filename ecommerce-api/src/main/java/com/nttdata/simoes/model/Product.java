package com.nttdata.simoes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Product {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
		
	@NotBlank(message = "Code cannot be left blank")
	@Column(nullable=false, unique=true)
	private String code;	//PRODUCT CODE CAN BE AUTOMATED ONCE MORE COLUMNS LIKE SECTION OR TYPE ARE ADDED	
	
	
	@NotBlank(message = "Name cannot be left blank")
	@Column(nullable=false)
	private String name;
	
	@NotBlank(message = "Price cannot be left blank")
	@Column(nullable=false)
	private float price;
	
	
	//------
	public Product() {
		
	}
	
	public Product(String code, String name, float price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}
	
	//GETTERS AND SETTERS	
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
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	//HASHCODE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
