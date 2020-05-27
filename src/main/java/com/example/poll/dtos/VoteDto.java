/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.poll.dtos;


/**
 *
 * @author Chris
 */

public class VoteDto {


    private Integer rating;
    private String firstname;
    private String lastname;

    public VoteDto(Integer rating, String firstname, String lastname) {
        this.rating = rating;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    public VoteDto() {}
    
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    
    
    
    
    
}

