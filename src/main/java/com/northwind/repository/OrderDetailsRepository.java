package com.northwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.northwind.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>{

}
