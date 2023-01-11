package com.nttdata.simoes.model;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="order_item")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Quantity cannot be empty")
	@Column(nullable=false)
	@Range(min=1, message = "Quantity minimum = 1")
	private int quantity;
	
	private float orderItemPrice;
	
	private String productName;
	
	private Long productId;

	//	@JsonBackReference
//	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"}) 
	@ManyToOne
	private Order order;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	private Product product;
	
	public OrderItem() {
		
	}	

	public OrderItem(Long id, int quantity, float orderItemPrice, Long productId, String productName, Order order) {
	this.id = id;
	this.quantity = quantity;
	this.orderItemPrice = orderItemPrice;
	this.productId = productId;
	this.productName = productName;
	this.order = order;
}

	public OrderItem(int quantity, Long productId) {
		this.quantity = quantity;
		this.productId = productId;
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

	public float getOrderItemPrice() {
		return orderItemPrice;
	}

	public void setOrderItemPrice(float orderItemPrice) {
		this.orderItemPrice = orderItemPrice;
	}


	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

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
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}

		
}
