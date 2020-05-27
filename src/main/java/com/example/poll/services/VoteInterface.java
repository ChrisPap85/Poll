/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.poll.services;

import com.example.poll.dtos.VoteDto;
import com.example.poll.models.Pollvote;
import java.util.List;

/**
 *
 * @author Chris
 */
public interface VoteInterface {
    
         public List<Pollvote> getAllVotes();

     public void insertVote(Pollvote pollvote);
     
   public Pollvote findbyVoterID(Integer voterid);  
   
   
   public List<Pollvote> getVotesbyCandId(Integer candidateid);
   
   

}
