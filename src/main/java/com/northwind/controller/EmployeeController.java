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
	
	@GetMapping("{employeeId}")
	public ResponseEntity<Employee> findById(@PathVariable int employeeId){
		return ResponseEntity.of(employeeRepository.findById(employeeId));
	}
	
	@PostMapping
	public ResponseEntity<Integer> save(@RequestBody Employee employee){
		Employee save = employeeRepository.save(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(save.getEmployeeId());
	}
}







