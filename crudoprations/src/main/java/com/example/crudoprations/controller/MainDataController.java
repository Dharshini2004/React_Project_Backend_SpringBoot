package com.example.crudoprations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudoprations.model.MainData;
import com.example.crudoprations.service.MainDataService;

@RestController
public class MainDataController {
    @Autowired
    MainDataService maindataservice;

    //post
    @PostMapping("/addmaindata")
    public ResponseEntity<MainData> addLoginData( @RequestBody MainData maindata)
    {
        MainData md=maindataservice.createUserLogin(maindata);
        return new ResponseEntity<>(md,HttpStatus.CREATED);
    }

    //get
    @GetMapping("/getmaindata")
    public ResponseEntity<java.util.List<MainData>> showLoginDate()
    {
        return new ResponseEntity<>(maindataservice.getUserLogin(),HttpStatus.OK);
    }

    
    //put
    @PutMapping("/putmaindata/{Id}")
    public ResponseEntity<MainData> updateLogin(@PathVariable("Id") Long Id,@RequestBody MainData maindata )
    {   
        if(maindataservice.updateUserLogin(Id, maindata)==true)
        {

            return new ResponseEntity<>(maindata,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    //DELETE
    @DeleteMapping("/deletemaindata/{Id}")
    public ResponseEntity<Boolean> deleteLogin(@PathVariable("Id") Long Id)
    {
        if(maindataservice.deleteUserLogin(Id)==true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
    
}
