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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "pollrole")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pollrole.findAll", query = "SELECT p FROM Pollrole p"),
    @NamedQuery(name = "Pollrole.findByRoleid", query = "SELECT p FROM Pollrole p WHERE p.roleid = :roleid"),
    @NamedQuery(name = "Pollrole.findByRolename", query = "SELECT p FROM Pollrole p WHERE p.rolename = :rolename")})
public class Pollrole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROLEID")
    private Integer roleid;
    @Size(max = 10)
    @Column(name = "ROLENAME")
    private String rolename;
    @OneToMany(mappedBy = "uroleid")
    private Collection<Polluser> polluserCollection;

    public Pollrole() {
    }

    public Pollrole(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @XmlTransient
    public Collection<Polluser> getPolluserCollection() {
        return polluserCollection;
    }

    public void setPolluserCollection(Collection<Polluser> polluserCollection) {
        this.polluserCollection = polluserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleid != null ? roleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pollrole)) {
            return false;
        }
        Pollrole other = (Pollrole) object;
        if ((this.roleid == null && other.roleid != null) || (this.roleid != null && !this.roleid.equals(other.roleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.poll.models.Pollrole[ roleid=" + roleid + " ]";
    }
    
}
