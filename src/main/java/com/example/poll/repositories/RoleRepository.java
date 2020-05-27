/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.poll.repositories;

import com.example.poll.models.Pollrole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Chris
 */
@Repository
public interface RoleRepository extends JpaRepository<Pollrole , Integer> {
    

}


