/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.poll.services;

import com.example.poll.models.Polluser;
import java.util.List;

/**
 *
 * @author Chris
 */
public interface UserInterface {
    
  
 
 
    
 public void registerUser(Polluser polluser);
 
     public Polluser findByUserName(String uloginname); 
     
     public List<Polluser> allCandidates(Integer uid);
     
     public Polluser findByUid (int uid);
     
     public List<Polluser> allUsers();
}
