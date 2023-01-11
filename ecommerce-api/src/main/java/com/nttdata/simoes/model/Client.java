package com.nttdata.simoes.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "First name cannot be blank")
	@Column(name="first_name",nullable=false)
	private String firstName;
	
	@NotBlank(message = "Last name cannot be blank")
	@Column(name="last_name",nullable=false)
	private String lastName;
	
	@NotBlank(message = "Address cannot be blank")
	@Column(nullable=false)
	private String address;
	
	@NotBlank(message = "Email cannot be blank")
	@Column(nullable=false, unique=true)
	private String email;
	
	@NotBlank(message = "NIF cannot be blank")
	@Column(nullable=false, unique=true, length=9)
	private String nif;
	
	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	private List<Order> orderList;
	
	//-----
	public Client() {
		
	}
	
	public Client(String firstName, String lastName, String address, String email, String nif) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.nif = nif;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}		
	
		

}
