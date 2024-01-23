package com.northwind.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.northwind.repository.OrderDetailsRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor 
@RequestMapping(path = "order-details")
public class OrderDetailsController {

	OrderDetailsRepository orderDetailsRepository;
}
