package com.webserviceadmin.domain;

import javax.persistence.*;

/**
 *
 * @author cesi
 */
@Entity
@Table(name="Users")
public class Users 
{
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="ID")
    private Long Id;
    
    @Column(name="FirstName")
    private String FirstName;
    @Column(name="LastName")
    private String LastName;

    public Long getId() {
        return Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
}
