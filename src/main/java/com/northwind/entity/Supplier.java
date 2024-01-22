package com.northwind.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Suppliers")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplierid")
	private int supplierId;
	
	@Column(name = "suppliername")
	private String supplierName;
	
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
	
	@Column(name = "phone")
	private String phone;
}
