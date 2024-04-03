package com.example.crudoprations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudoprations.model.MainData;

public interface MainRepo extends JpaRepository<MainData,Long>{
    
}
