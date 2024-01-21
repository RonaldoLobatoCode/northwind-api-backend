package com.northwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.northwind.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
