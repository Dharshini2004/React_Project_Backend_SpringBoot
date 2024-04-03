package com.example.crudoprations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudoprations.model.UserLogin;

public interface UserLoginRepo extends JpaRepository<UserLogin,Long>{
    
}
