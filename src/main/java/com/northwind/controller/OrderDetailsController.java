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
	
	@GetMapping("{orderDetailId}")
	public ResponseEntity<OrderDetails> findById(@PathVariable int orderDetailId){
		return ResponseEntity.of(orderDetailsRepository.findById(orderDetailId));
	}
	
	@PostMapping
	public ResponseEntity<Integer> register(@RequestBody OrderDetails orderDetails){
		OrderDetails save = orderDetailsRepository.save(orderDetails);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(save.getOrderDetailId());
	}
	
	@PutMapping("{orderDetailId}")
	public ResponseEntity<OrderDetails> update(@PathVariable int orderDetailId, @RequestBody OrderDetails updateOrderDetailId){
		Optional<OrderDetails> optionalOrderDetail = orderDetailsRepository.findById(orderDetailId);
		if(optionalOrderDetail.isPresent()) {
			OrderDetails existingOrderDetails = optionalOrderDetail.get();
			existingOrderDetails.setOrderId(updateOrderDetailId.getOrderId());
			existingOrderDetails.setProductId(updateOrderDetailId.getProductId());
			existingOrderDetails.setQuantity(updateOrderDetailId.getQuantity());
			
			OrderDetails entity = orderDetailsRepository.save(existingOrderDetails);
			return ResponseEntity.ok(entity);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{orderDetailId}")
	public void delete(@PathVariable int orderDetailId) {
		orderDetailsRepository.deleteById(orderDetailId);
	}
}








