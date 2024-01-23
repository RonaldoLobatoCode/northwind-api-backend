package com.northwind.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Orderdetails")
@Data
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderdetailid")
	private int orderDetailId;
	
	@Column(name = "orderid")
	private int orderId;
	
	@Column(name = "productid")
	private int productId;
	
	@Column(name = "quantity")
	private int quantity;
}
