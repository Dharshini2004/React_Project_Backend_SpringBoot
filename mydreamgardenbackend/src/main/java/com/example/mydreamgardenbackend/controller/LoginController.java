package com.example.mydreamgardenbackend.controller;

import java.util.List;

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

import com.example.mydreamgardenbackend.model.Login;
import com.example.mydreamgardenbackend.service.LoginService;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    //post
    @PostMapping("/adduserlogindata")
    public ResponseEntity<Login> addLoginData( @RequestBody Login userlog)
    {
        Login ul=loginService.createUserLogin(userlog);
        return new ResponseEntity<>(ul,HttpStatus.CREATED);
    }

    //get
    @GetMapping("/getuserlogindata")
    public ResponseEntity<java.util.List<Login>> showLoginDate()
    {
        return new ResponseEntity<>(loginService.getUserLogin(),HttpStatus.OK);
    }

    
    //put
    @PutMapping("/putuserlogindata/{Id}")
    public ResponseEntity<Login> updateLogin(@PathVariable("Id") int Id,@RequestBody Login login )
    {   
        if(loginService.updateUserLogin(Id, login)==true)
        {

            return new ResponseEntity<>(login,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    //DELETE
    @DeleteMapping("/deleteuserlogindata/{Id}")
    public ResponseEntity<Boolean> deleteLogin(@PathVariable("Id") int Id)
    {
        if(loginService.deleteUserLogin(Id)==true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    //sorting
    @GetMapping("/login/sortBy/{field}")
    public List<Login> g(@PathVariable String field)
    {
        return loginService.sort(field);
    }

    //pagination
    @GetMapping("/login/{offset}/{pagesize}")
    public List<Login> get(@PathVariable int offset,@PathVariable int pagesize)
    {
        return loginService.page(pagesize, offset);
    }
    
    //sorting and pagination
    @GetMapping("/login/{offset}/{pagesize}/{field}")
    public List<Login> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        return loginService.getsort(offset,pagesize,field);
    }

    // //get all sort using query
    @GetMapping("/query/{id}")
    public ResponseEntity<Login> findPetById(@PathVariable int id) 
    {
        Login sh = loginService.findUserById(id);
        try{
            return new ResponseEntity<>(sh,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(sh,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
}
