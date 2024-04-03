package com.example.mainbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mainbackend.model.MainData;

public interface MainRepo extends JpaRepository<MainData,Long>{
    
}
