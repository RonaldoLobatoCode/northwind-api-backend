package com.northwind.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Shippers")
@Data
public class Shippers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shipperid")
	private int shipperId;
	
	@Column(name = "shippername")
	private String shipperName;
	
	@Column(name = "phone")
	private String phone;
}
