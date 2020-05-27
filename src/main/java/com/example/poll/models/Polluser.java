/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.poll.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "polluser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Polluser.findAll", query = "SELECT p FROM Polluser p"),
    @NamedQuery(name = "Polluser.findByUid", query = "SELECT p FROM Polluser p WHERE p.uid = :uid"),
    @NamedQuery(name = "Polluser.findByUsername", query = "SELECT p FROM Polluser p WHERE p.username = :username"),
    @NamedQuery(name = "Polluser.findByUname", query = "SELECT p FROM Polluser p WHERE p.uname = :uname"),
    @NamedQuery(name = "Polluser.findByUpassword", query = "SELECT p FROM Polluser p WHERE p.upassword = :upassword"),
    @NamedQuery(name = "Polluser.findByUloginname", query = "SELECT p FROM Polluser p WHERE p.uloginname = :uloginname")})
public class Polluser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UID")
    private Integer uid;
    @Size(max = 20)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 20)
    @Column(name = "UNAME")
    private String uname;
    @Size(max = 60)
    @Column(name = "UPASSWORD")
    private String upassword;
    @Size(max = 20)
    @Column(name = "ULOGINNAME")
    private String uloginname;
    @JoinColumn(name = "UROLEID", referencedColumnName = "ROLEID")
    @ManyToOne
    private Pollrole uroleid;
    @OneToMany(mappedBy = "candidateid")
    private Collection<Pollvote> pollvoteCollection;
    @OneToOne(mappedBy = "voterid")
    private Pollvote pollvote;

    public Polluser() {
    }

    public Polluser(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUloginname() {
        return uloginname;
    }

    public void setUloginname(String uloginname) {
        this.uloginname = uloginname;
    }

    public Pollrole getUroleid() {
        return uroleid;
    }

    public void setUroleid(Pollrole uroleid) {
        this.uroleid = uroleid;
    }

    @XmlTransient
    public Collection<Pollvote> getPollvoteCollection() {
        return pollvoteCollection;
    }

    public void setPollvoteCollection(Collection<Pollvote> pollvoteCollection) {
        this.pollvoteCollection = pollvoteCollection;
    }

    public Pollvote getPollvote() {
        return pollvote;
    }

    public void setPollvote(Pollvote pollvote) {
        this.pollvote = pollvote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Polluser)) {
            return false;
        }
        Polluser other = (Polluser) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.poll.models.Polluser[ uid=" + uid + " ]";
    }
    
}
