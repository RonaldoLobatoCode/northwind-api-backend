package com.northwind.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping
	public ResponseEntity<Integer> register(@RequestBody Supplier supplier){
		Supplier save = supplierRepository.save(supplier);
		return ResponseEntity.status(HttpStatus.CREATED).body(save.getSupplierId());
	}
	
	@PutMapping("{supplierId}")
	public ResponseEntity<Supplier> update(@PathVariable int supplierId, @RequestBody Supplier updatedsupplier){
		Optional<Supplier> supplierOptional = supplierRepository.findById(supplierId);
		if(supplierOptional.isPresent()) {
			Supplier existingSupplier = supplierOptional.get();
			existingSupplier.setSupplierName(updatedsupplier.getSupplierName());
			existingSupplier.setContactName(updatedsupplier.getContactName());
			existingSupplier.setAddress(updatedsupplier.getAddress());
			existingSupplier.setCity(updatedsupplier.getCity());
			existingSupplier.setPostalCode(updatedsupplier.getPostalCode());
			existingSupplier.setCountry(updatedsupplier.getCountry());
			existingSupplier.setPhone(updatedsupplier.getPhone());
			
			Supplier updatedSupplierEntity = supplierRepository.save(existingSupplier);
			return ResponseEntity.ok(updatedSupplierEntity);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
















