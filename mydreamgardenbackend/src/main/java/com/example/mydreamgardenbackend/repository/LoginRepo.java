package com.example.mydreamgardenbackend.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mydreamgardenbackend.model.Login;


public interface LoginRepo extends JpaRepository<Login,Integer>{

    @Query("SELECT s FROM Login s WHERE s.id = :id")
    Login findUserById(@RequestParam("id") int id);

    
}
