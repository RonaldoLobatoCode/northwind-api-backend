package com.northwind.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.northwind.entity.Employee;
import com.northwind.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "employees")
public class EmployeeController {

	EmployeeRepository employeeRepository;
	
	@GetMapping
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
}
