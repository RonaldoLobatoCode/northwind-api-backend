package com.northwind.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Customers")
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerid")
	private int customerId;
	
	@Column(name = "customername")
	private String customerName;
	
	@Column(name = "contactname")
	private String contactName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "postalcode")
	private String postalCode;
	
	@Column(name = "country")
	private String country;
}
