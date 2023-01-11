package com.nttdata.simoes.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name="order_table")
@Entity //MAKES THIS A TABLE
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="initial_date")
	private LocalDate initialDate;
	@Column(name="delivery_date")
	private LocalDate deliveryDate;
	
	//private Long clientId;
	
	//private Long orderId;
	
	//@JsonManagedReference
	@OneToMany(targetEntity = OrderItem.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private List<OrderItem> orderItemList;

	@ManyToOne(fetch = FetchType.LAZY)
	private Client client;
	
	@Column(name="order_price")
	private float orderPrice;
	
	public Order() {
		
	}
	

	public Order(Long id, LocalDate initialDate, LocalDate deliveryDate, List<OrderItem> orderItemList, Client client,
			float orderPrice) { //, Long clientId, Long orderId
		this.id = id;
		this.initialDate = initialDate;
		this.deliveryDate = deliveryDate;
		this.orderItemList = orderItemList;
		this.client = client;
		this.orderPrice = orderPrice;
		//this.clientId = clientId;
		//this.orderId = orderId;
	}

	public Order(Client client, List<OrderItem> orderItemList) {
		//this.clientId=clientId;
		//this.orderId = orderId;
		this.client = client;
		this.orderItemList = orderItemList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public LocalDate getInitialDate() {
		return initialDate;
	}



	public void setInitialDate(LocalDate initialDate) {
		this.initialDate = initialDate;
	}



	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}



	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}



	public float getOrderPrice() {
		return orderPrice;
	}



	public void setOrderPrice(float orderPrice) {
		this.orderPrice = orderPrice;
	}


//	public Long getClientId() {
//		return clientId;
//	}
//
//
//	public void setClientId(Long clientId) {
//		this.clientId = clientId;
//	}


//	public Long getOrderId() {
//		return orderId;
//	}
//
//
//	public void setOrderId(Long orderId) {
//		this.orderId = orderId;
//	}
	
	
	
	
}
