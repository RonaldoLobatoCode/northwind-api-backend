package com.northwind.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderDetails")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ordedetailid")
	private int orderDetailId;
	
	@Column(name = "orderid")
	private int orderId;
	
	@Column(name = "productid")
	private int productId;
	
	@Column(name = "quantity")
	private int quantity;
}
