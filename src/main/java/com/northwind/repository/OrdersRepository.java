package com.northwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.northwind.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}
