package com.northwind.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
}
