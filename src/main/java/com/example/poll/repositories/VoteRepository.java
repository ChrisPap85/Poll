/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.poll.repositories;

import com.example.poll.dtos.VoteDto;
import com.example.poll.models.Pollvote;
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
public interface VoteRepository extends JpaRepository<Pollvote, Integer>{
    
  
@Query(
  value = "SELECT * FROM poll.pollvote where voterid = :voterid", 
  nativeQuery = true)
Pollvote findByVoterId(@Param("voterid") Integer voterid);

 

@Query(
  value = "SELECT * FROM poll.pollvote where CANDIDATEID = :CANDIDATEID" , 
  nativeQuery = true)
List<Pollvote> findByCandiId(@Param("CANDIDATEID") Integer CANDIDATEID);

} 
       
    
    

