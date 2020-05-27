/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.poll.controllers;

import com.example.poll.dtos.UserDto;
import com.example.poll.models.Pollrole;
import com.example.poll.models.Polluser;
import com.example.poll.models.Pollvote;
import com.example.poll.services.RoleInterface;
import com.example.poll.services.UserInterface;
import com.example.poll.services.VoteInterface;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Chris
 */
@Controller
public class PolluserController {

    @Autowired
    RoleInterface rolein;

    @Autowired
    UserInterface uint;

    @Autowired
    VoteInterface voteint;
    

    @GetMapping(value = "/")
    public String showHomePage() {
        return "homepage";

    }

    @GetMapping(value = "/register")
    public String preRegisterUser(ModelMap mm) {
        UserDto udt = new UserDto();

        List<Pollrole> allroles = rolein.getAllRoles();

        mm.addAttribute("rolesapp", allroles);
        mm.addAttribute("polluser", udt);

        return "regform";
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value = "/registeruser")
    public String registerUser(@ModelAttribute(value = "newuser") UserDto udt,
            ModelMap mm, RedirectAttributes atts) {
        if (uint.findByUserName(udt.getUloginname()) != null){
        
        return "alreadyexist";
        }
        Polluser pos = new Polluser();
        pos.setUsername(udt.getUsername());

        pos.setUloginname(udt.getUloginname());

        pos.setUname(udt.getUname());
        pos.setUloginname(udt.getUloginname());

        if (udt.getUpassword1().equals(udt.getUpassword2())) {
            String password = udt.getUpassword1();
            String hashpassword = passwordEncoder.encode(password);
            pos.setUpassword(hashpassword);

        } else {
            return "redirect:/register";
        }
        pos.setUroleid(udt.getPollrole());

        uint.registerUser(pos);

        return "homepage";
    }

    @GetMapping(value = "/login")
    public String preLoginUser(ModelMap mm) {
        UserDto udt = new UserDto();

        mm.addAttribute("finduser", udt);

        return "loginform";
    }

    @PostMapping(value = "/loginuser")
    public String loginUser(@ModelAttribute(value = "finduser") UserDto udt,
            ModelMap mm, HttpSession session) {
        
        

 
        
        
        if (uint.findByUserName(udt.getUloginname()) == null || udt.getUpassword1() == null || (uint.findByUserName(udt.getUloginname())).getUpassword() == null ) {

            return "wronguser";
            
            
        } else if (passwordEncoder.matches(udt.getUpassword1(),(uint.findByUserName(udt.getUloginname())).getUpassword() )) {

            Polluser LogUser = uint.findByUserName(udt.getUloginname());
            session.setAttribute("LoggedUser", LogUser);
            session.setAttribute("LoggedUserName", udt.getUloginname());

            // Παιρνω το id  για να δω αν έχει ψηφίσει μετά
            int sessionid = uint.findByUserName(udt.getUloginname()).getUid();

            // Παίρνω το id  για να δω αν είναι ψηφοφόρος ή υποψήφιος
            int vote_number = (uint.findByUserName(udt.getUloginname())).getUroleid().getRoleid();

            // Επιστρέφω την ανάλογη σελίδα βάση της ιδιότητας του χρήστη
            if (voteint.findbyVoterID(sessionid) == null) {

                if (vote_number == 1) {
                    return "redirect:/voterpage";
                } else {
                    return "redirect:/candidatepage";
                }
            } else {

                if (vote_number == 1) {
                    return "thankpage";
                } else {
                    return "thankpagecand";
                }
            }
        } else {
            return "wrongpass";
        }
    }

    @GetMapping(value = "/candidatepage")
    public String fetchAllCandidates(ModelMap mm, HttpSession session
    ) {

        // Παίρνω id του  Candidate  για να μην εμφανιστεί στην λίστα
        String UserName = (String) session.getAttribute("LoggedUserName");
        int userid = uint.findByUserName(UserName).getUid();
        List<Polluser> result = uint.allCandidates(userid);

        mm.addAttribute("allcandidates", result);

        return "candidatepage";
    }

    @GetMapping(value = "/vote/{id}/{rate}")
    public String vote(ModelMap mm,
            @PathVariable int id,
            @PathVariable int rate, HttpSession session
    ) {

        Pollvote pov = new Pollvote();

        Date date = new Date();
        pov.setDatetime(date);

        pov.setRating(rate);
        pov.setCandidateid(uint.findByUid(id));
        String UserName = (String) session.getAttribute("LoggedUserName");
        pov.setVoterid(uint.findByUserName(UserName));

        voteint.insertVote(pov);

        return "thankpage";
    }
    @GetMapping(value = "/voterpage")
    public String fetchAllCandidates2(ModelMap mm, HttpSession session
    ) {

        // Παίρνω id του  Candidate  για να μην εμφανιστεί στην λίστα
        String UserName = (String) session.getAttribute("LoggedUserName");
        int userid = uint.findByUserName(UserName).getUid();
        List<Polluser> result = uint.allCandidates(userid);

        mm.addAttribute("allcandidates", result);

        return "voterpage";
    }
    
    
     @GetMapping(value = "/resultpage")
    public String showResults(ModelMap mm, HttpSession session) {
        
        String UserName = (String) session.getAttribute("LoggedUserName");
        int candId = uint.findByUserName(UserName).getUid();
        
//Λίστα με όσους ψήφισαν τον υποψήφιο με αυτό το id
        
        List<Pollvote> candVotes = voteint.getVotesbyCandId(candId);
        
        mm.addAttribute("allvoters", candVotes);
    
       
        return "results";
    }
}
