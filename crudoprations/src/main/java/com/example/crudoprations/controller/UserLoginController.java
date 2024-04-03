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

import com.example.crudoprations.model.UserLogin;
import com.example.crudoprations.service.UserLoginService;

@RestController
public class UserLoginController {
    @Autowired
    UserLoginService userlogs;

    //post
    @PostMapping("/adduserlogindata")
    public ResponseEntity<UserLogin> addLoginData( @RequestBody UserLogin userlog)
    {
        UserLogin ul=userlogs.createUserLogin(userlog);
        return new ResponseEntity<>(ul,HttpStatus.CREATED);
    }

    //get
    @GetMapping("/getuserlogindata")
    public ResponseEntity<java.util.List<UserLogin>> showLoginDate()
    {
        return new ResponseEntity<>(userlogs.getUserLogin(),HttpStatus.OK);
    }

    
    //put
    @PutMapping("/putuserlogindata/{Id}")
    public ResponseEntity<UserLogin> updateLogin(@PathVariable("Id") Long Id,@RequestBody UserLogin userlog )
    {   
        if(userlogs.updateUserLogin(Id, userlog)==true)
        {

            return new ResponseEntity<>(userlog,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    //DELETE
    @DeleteMapping("/deleteuserlogindata/{Id}")
    public ResponseEntity<Boolean> deleteLogin(@PathVariable("Id") Long Id)
    {
        if(userlogs.deleteUserLogin(Id)==true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

}
