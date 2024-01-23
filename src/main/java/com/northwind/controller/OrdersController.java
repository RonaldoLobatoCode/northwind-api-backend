package com.northwind.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
}
