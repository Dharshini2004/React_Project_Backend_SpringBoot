package com.example.mydreamgardenbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mydreamgardenbackend.model.Order;

public interface OrderRepo extends JpaRepository<Order,Integer>{
    
}
