/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.poll.dtos;

import com.example.poll.models.Pollrole;

/**
 *
 * @author Chris
 */
public class UserDto {
    
    private String username;
    private String uname;
    private String upassword1;
    private String upassword2;
    private String uloginname;
    private Pollrole pollrole;

    public UserDto() {
    }

    public UserDto(String username, String uname, String upassword1, String upassword2, String uloginname, Pollrole pollrole) {
        this.username = username;
        this.uname = uname;
        this.upassword1 = upassword1;
        this.upassword2 = upassword2;
        this.uloginname = uloginname;
        this.pollrole = pollrole;
    }

    public UserDto(String upassword1, String uloginname) {
        this.upassword1 = upassword1;
        this.uloginname = uloginname;
    }
    
    
   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword1() {
        return upassword1;
    }

    public void setUpassword1(String upassword1) {
        this.upassword1 = upassword1;
    }

    public String getUpassword2() {
        return upassword2;
    }

    public void setUpassword2(String upassword2) {
        this.upassword2 = upassword2;
    }

    public String getUloginname() {
        return uloginname;
    }

    public void setUloginname(String uloginname) {
        this.uloginname = uloginname;
    }

    public Pollrole getPollrole() {
        return pollrole;
    }

    public void setPollrole(Pollrole pollrole) {
        this.pollrole = pollrole;
    }
      
}









