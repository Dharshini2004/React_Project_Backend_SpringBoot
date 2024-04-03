package com.example.mainbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mainbackend.model.MainData;
import com.example.mainbackend.repository.MainRepo;

@Service
public class MainDataService {
    @Autowired
    MainRepo mainrepo;

    //post or create
    public MainData createUserLogin(MainData maindata)
    {
        return mainrepo.save(maindata);
    }

    //get
    public List<MainData> getUserLogin()
    {
        return mainrepo.findAll();
    }
    //get by id
    public MainData getUserById(Long Id)
    {
        return mainrepo.findById(Id).orElse(null);
    }

    //update or put
    public boolean updateUserLogin(Long Id,MainData userlog)
    {
        if(this.getUserById(Id)==null)
        {
            return false;
        }
        try{
            mainrepo.save(userlog);
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
        mainrepo.deleteById(Id);
        return true;
    }
}
