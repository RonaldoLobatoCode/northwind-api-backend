package com.northwind.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("{customerId}")
	public ResponseEntity<Customer> findById(@PathVariable int customerId){
		return ResponseEntity.of(customerRepository.findById(customerId));
	}
	
	@PostMapping
	public ResponseEntity<Integer> save(@RequestBody Customer customer){
		Customer save = customerRepository.save(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(save.getCustomerId());
	}
	
	@PutMapping("{customerId}")
	public ResponseEntity<Customer> update(@PathVariable int customerId,@RequestBody Customer updatedCustomer){
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if(customerOptional.isPresent()) {
			Customer existingCustomer = customerOptional.get();
			existingCustomer.setCustomerName(updatedCustomer.getCustomerName());
			existingCustomer.setContactName(updatedCustomer.getContactName());
			existingCustomer.setAddress(updatedCustomer.getAddress());
			existingCustomer.setCity(updatedCustomer.getCity());
			existingCustomer.setPostalCode(updatedCustomer.getPostalCode());
			existingCustomer.setCountry(updatedCustomer.getCountry());
			
			Customer updateCustomerEntity = customerRepository.save(existingCustomer);
			
			return ResponseEntity.ok(updateCustomerEntity);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{customerId}")
	public void delete(@PathVariable int customerId) {
		customerRepository.deleteById(customerId);
	}
}











