/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.poll.services;

import com.example.poll.models.Pollrole;
import com.example.poll.repositories.RoleRepository;
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
public class RoleInterfaceImp implements RoleInterface{

    @Autowired
    RoleRepository rolre;
    
    @Override
    public List<Pollrole> getAllRoles() {
        
       return rolre.findAll();
    }

}
        
    
    

