package com.example.crudoprations.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudoprations.model.UserLogin;
import com.example.crudoprations.repository.UserLoginRepo;

@Service
public class UserLoginService {
    @Autowired
    UserLoginRepo userlogr;

    //post or create
    public UserLogin createUserLogin(UserLogin userlog)
    {
        return userlogr.save(userlog);
    }

    //get
    public List<UserLogin> getUserLogin()
    {
        return userlogr.findAll();
    }
    //get by id
    public UserLogin getUserById(Long Id)
    {
        return userlogr.findById(Id).orElse(null);
    }

    //update or put
    public boolean updateUserLogin(Long Id,UserLogin userlog)
    {
        if(this.getUserById(Id)==null)
        {
            return false;
        }
        try{
            userlogr.save(userlog);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    //delete
    public boolean deleteUserLogin(Long Id)
    {
        if(this.getUserById(Id)==null)
        {
            return false;
        }
        userlogr.deleteById(Id);
        return true;
    }

}
