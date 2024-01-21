package com.northwind.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.northwind.entity.Product;
import com.northwind.repository.ProductRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "products")
public class ProductController {
	
	ProductRepository productRepository;
	
	@GetMapping
	public List<Product> findAll(){
		return productRepository.findAll();
	}
}
