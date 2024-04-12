package com.example.mydreamgardenbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mydreamgardenbackend.model.Products;

public interface ProductsRepo extends JpaRepository<Products,Integer>{
    
}
