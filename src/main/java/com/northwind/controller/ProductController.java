package com.northwind.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("{productId}")
	public ResponseEntity<Product> update(@PathVariable int productId, @RequestBody Product updatedProduct){
		Optional<Product> productOptional = productRepository.findById(productId);
		if(productOptional.isPresent()) {
			Product existingProduct  = productOptional.get();
			existingProduct.setProductName(updatedProduct.getProductName());
			existingProduct.setSupplierId(updatedProduct.getSupplierId());
	        existingProduct.setCategoryId(updatedProduct.getCategoryId());
	        existingProduct.setUnit(updatedProduct.getUnit());
	        existingProduct.setPrice(updatedProduct.getPrice());
			
	        Product updateProductEntity = productRepository.save(existingProduct);
	        
	        return ResponseEntity.ok(updateProductEntity);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("{productId}")
	public void delete(@PathVariable int productId) {
		productRepository.deleteById(productId);
	}
}





















