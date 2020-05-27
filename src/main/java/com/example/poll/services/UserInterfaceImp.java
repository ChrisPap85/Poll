/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.poll.services;

import com.example.poll.models.Pollrole;
import com.example.poll.models.Polluser;
import com.example.poll.repositories.UserRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chris
 */
@Service
@Transactional
public class UserInterfaceImp implements UserInterface{

    @Autowired
    UserRepository urepo;
    
   
    @Override
    public void registerUser(Polluser polluser) {

    urepo.save(polluser);
    
    
    }

    @Override
    public Polluser findByUserName(String uloginname) {
        
    return urepo.findByUloginname(uloginname);
    }

    @Override
    public List<Polluser> allCandidates(Integer uid) {
 List<Polluser> result = (List<Polluser>) urepo.findAllCandidates(uid);
 
 return result;
    }

    @Override
    public Polluser findByUid(int uid) {

       return urepo.findById(uid).get();
    }

    @Override
    public List<Polluser> allUsers() {

      return  urepo.findAll();
    }

 
    
}
    
        
    
    

