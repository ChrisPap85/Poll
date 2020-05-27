/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.poll.models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "pollvote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pollvote.findAll", query = "SELECT p FROM Pollvote p"),
    @NamedQuery(name = "Pollvote.findByVoteid", query = "SELECT p FROM Pollvote p WHERE p.voteid = :voteid"),
    @NamedQuery(name = "Pollvote.findByDatetime", query = "SELECT p FROM Pollvote p WHERE p.datetime = :datetime"),
    @NamedQuery(name = "Pollvote.findByRating", query = "SELECT p FROM Pollvote p WHERE p.rating = :rating")
})
public class Pollvote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VOTEID")
    private Integer voteid;
    @Column(name = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "RATING")
    private Integer rating;
    @JoinColumn(name = "CANDIDATEID", referencedColumnName = "UID")
    @ManyToOne
    private Polluser candidateid;
    @JoinColumn(name = "VOTERID", referencedColumnName = "UID")
    @OneToOne
    private Polluser voterid;

    public Pollvote() {
    }

    public Pollvote(Integer voteid) {
        this.voteid = voteid;
    }

    public Integer getVoteid() {
        return voteid;
    }

    public void setVoteid(Integer voteid) {
        this.voteid = voteid;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Polluser getCandidateid() {
        return candidateid;
    }

    public void setCandidateid(Polluser candidateid) {
        this.candidateid = candidateid;
    }

    public Polluser getVoterid() {
        return voterid;
    }

    public void setVoterid(Polluser voterid) {
        this.voterid = voterid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (voteid != null ? voteid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pollvote)) {
            return false;
        }
        Pollvote other = (Pollvote) object;
        if ((this.voteid == null && other.voteid != null) || (this.voteid != null && !this.voteid.equals(other.voteid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.poll.models.Pollvote[ voteid=" + voteid + " ]";
    }
    
}
