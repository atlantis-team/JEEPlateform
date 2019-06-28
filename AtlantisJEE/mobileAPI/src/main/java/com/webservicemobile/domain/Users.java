package com.webservicemobile.domain;

import java.util.ArrayList;
import java.util.List;
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
    //@Column(name="ID")
    //private Long Id;
    @Column(name="oid")
    private String oid;
    @Column(name="FirstName")
    private String FirstName;
    @Column(name="LastName")
    private String LastName;
    
        public String getOid() {
        return oid;
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
