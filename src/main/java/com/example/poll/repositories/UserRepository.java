/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.poll.repositories;

import com.example.poll.models.Polluser;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Chris
 */
@Repository
public interface UserRepository extends JpaRepository<Polluser, Integer>{
    
    
   Polluser findByUloginname(String uloginname);
   
   
   @Query(
  value = "SELECT * FROM poll.polluser where UROLEID=2 AND UID!= :UID", 
  nativeQuery = true)
List<Polluser> findAllCandidates(@Param("UID") Integer UID);



}