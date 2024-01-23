package com.northwind.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.northwind.entity.OrderDetails;
import com.northwind.repository.OrderDetailsRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor 
@RequestMapping(path = "order-details")
public class OrderDetailsController {

	OrderDetailsRepository orderDetailsRepository;
	
	@GetMapping
	public List<OrderDetails> findAll(){
		return orderDetailsRepository.findAll();
	}
}
