package com.northwind.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Products")
@Data
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private int productId;

    @Column(name = "productname")
    private String productName;

    @Column(name = "supplierid")
    private int supplierId;

    @Column(name = "categoryid")
    private int categoryId;

    @Column(name = "unit")
    private String unit;

    @Column(name = "price")
    private BigDecimal price;
}
