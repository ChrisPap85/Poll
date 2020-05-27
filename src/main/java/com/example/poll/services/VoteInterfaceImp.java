/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.poll.services;

import com.example.poll.models.Pollvote;
import com.example.poll.repositories.VoteRepository;
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
public class VoteInterfaceImp implements VoteInterface{

    @Autowired
    VoteRepository vrep;
    
    @Override
    public List<Pollvote> getAllVotes() {
       return vrep.findAll();
        
    }

    @Override
    public void insertVote(Pollvote pollvote) {

        vrep.save(pollvote);
        
    }

    @Override
    public Pollvote findbyVoterID(Integer voterid) {
       return vrep.findByVoterId(voterid);
    }

    @Override
    public List<Pollvote> getVotesbyCandId(Integer candidateid) {

        
        List<Pollvote> result = (List<Pollvote>) vrep.findByCandiId(candidateid);
 
 return result;
    }




   
    
    
}
