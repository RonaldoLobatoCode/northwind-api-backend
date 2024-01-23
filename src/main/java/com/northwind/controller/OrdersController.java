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

import com.northwind.entity.Orders;
import com.northwind.repository.OrdersRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "orders")
public class OrdersController {

	OrdersRepository ordersRepository;
	
	@GetMapping
	public List<Orders> findAll(){
		return ordersRepository.findAll();
	}
	
	@GetMapping("{orderId}")
	public ResponseEntity<Orders> findById(@PathVariable int orderId){
		return ResponseEntity.of(ordersRepository.findById(orderId));
	}
	
	@PostMapping
	public ResponseEntity<Integer> register(@RequestBody Orders orders){
		Orders save = ordersRepository.save(orders);
		return ResponseEntity.status(HttpStatus.CREATED).body(save.getOrderId());
	}
}
