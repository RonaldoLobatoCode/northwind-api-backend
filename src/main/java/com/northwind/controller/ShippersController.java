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

import com.northwind.entity.Shippers;
import com.northwind.repository.ShippersRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "shippers")
public class ShippersController {

	ShippersRepository shippersRepository;
	
	@GetMapping
	public List<Shippers> findAll(){
		return shippersRepository.findAll();
	}
	
	@GetMapping("{shipperId}")
	public ResponseEntity<Shippers> findById(@PathVariable int shipperId){
		return ResponseEntity.of(shippersRepository.findById(shipperId));
	}
	
	@PostMapping
	public ResponseEntity<Integer> register(@RequestBody Shippers shippers){
		Shippers save = shippersRepository.save(shippers);
		return ResponseEntity.status(HttpStatus.CREATED).body(save.getShipperId());
	}
	
	@PutMapping("{shipperId}")
	public ResponseEntity<Shippers> update(@PathVariable int shipperId, @RequestBody Shippers updatedShippers){
		Optional<Shippers> optionalShippers = shippersRepository.findById(shipperId);
		if(optionalShippers.isPresent()) {
			Shippers existingShippers = optionalShippers.get();
			existingShippers.setShipperName(updatedShippers.getShipperName());
			existingShippers.setPhone(updatedShippers.getPhone());
			
			Shippers updatedShippersEntity = shippersRepository.save(existingShippers);
			return ResponseEntity.ok(updatedShippersEntity);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}









