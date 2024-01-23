package com.northwind.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Orders")
@Data
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
	private int orderId;
	
	@Column(name = "customerid")
	private int customerId;
	
	@Column(name = "employeeid")
	private int employeeId;
	
	@Column(name = "orderdate")
	private Date orderDate;
	
	@Column(name = "shipperid")
	private int shipperId;
}
