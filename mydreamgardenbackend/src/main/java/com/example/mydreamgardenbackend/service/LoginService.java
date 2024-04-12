package com.example.mydreamgardenbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.mydreamgardenbackend.model.Login;
import com.example.mydreamgardenbackend.repository.LoginRepo;

@Service
public class LoginService {
    @Autowired
    LoginRepo loginRepo;

    //post or create
    public Login createUserLogin(Login login)
    {
        return loginRepo.save(login);
    }

    //get
    public List<Login> getUserLogin()
    {
        return loginRepo.findAll();
    }
    //get by id
    public Login getUserById(int id)
    {
        return loginRepo.findById(id).orElse(null);
    }

    //update or put
    public boolean updateUserLogin(int Id,Login login)
    {
        if(this.getUserById(Id)==null)
        {
            return false;
        }
        try{
            loginRepo.save(login);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    //delete
    public boolean deleteUserLogin(int Id)
    {
        if(this.getUserById(Id)==null)
        {
            return false;
        }
        loginRepo.deleteById(Id);
        return true;
    }

    //sorting by field
    public List<Login> sort(String field)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,field);
        return loginRepo.findAll(sort);
    }

    //pagination
    public List<Login> page(int pageSize,int pageNumber)
    {
        Pageable page=PageRequest.of(pageNumber, pageSize);
        return loginRepo.findAll(page).getContent();
    }

    //sorting and pagination
    public List<Login> getsort(int pageNumber,int pageSize,String field)
    {          return loginRepo.findAll(PageRequest.of(pageNumber, pageSize)
          .withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }



    public Login findUserById(int id) {
        return loginRepo.findUserById(id);
    }
}
