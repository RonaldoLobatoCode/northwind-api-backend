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
		
	@PutMapping("{employeeId}")
	public ResponseEntity<Employee> update(@PathVariable int employeeId, @RequestBody Employee updatedEmployee){
		Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
		if(employeeOptional.isPresent()) {
			Employee existingEmployee = employeeOptional.get();
			existingEmployee.setLastName(updatedEmployee.getLastName());
			existingEmployee.setFirstName(updatedEmployee.getFirstName());
			existingEmployee.setBirthDate(updatedEmployee.getBirthDate());
			existingEmployee.setPhoto(updatedEmployee.getPhoto());
			existingEmployee.setNotes(updatedEmployee.getNotes());
			
			Employee updateEmployeeEntity = employeeRepository.save(existingEmployee);
			
			return ResponseEntity.ok(updateEmployeeEntity);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}







