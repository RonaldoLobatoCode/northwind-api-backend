package com.northwind.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.northwind.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "employees")
public class EmployeeController {

	EmployeeRepository employeeRepository;
}
