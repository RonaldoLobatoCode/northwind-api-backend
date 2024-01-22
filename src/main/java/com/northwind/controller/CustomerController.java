package com.northwind.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.northwind.entity.Customer;
import com.northwind.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "customers")
public class CustomerController {

	CustomerRepository customerRepository;
	
	@GetMapping
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
}
