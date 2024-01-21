package com.northwind.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("{productId}")
	public ResponseEntity<Product> findByid(@PathVariable int productId){
		return ResponseEntity.of(productRepository.findById(productId));
	}
	
	@PostMapping
	public ResponseEntity<Integer> register(@RequestBody Product product) {
	    Product savedProduct = productRepository.save(product);
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct.getProductId());
	}

}





















