package com.northwind.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.northwind.entity.Supplier;
import com.northwind.repository.SupplierRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "suppliers")
public class SupplierController {

	SupplierRepository supplierRepository;
	
	@GetMapping
	public List<Supplier> findAll(){
		return supplierRepository.findAll();
	}
	
	@GetMapping("{supplierId}")
	public ResponseEntity<Supplier> findById(@PathVariable int supplierId){
		return ResponseEntity.of(supplierRepository.findById(supplierId));
	}
}
