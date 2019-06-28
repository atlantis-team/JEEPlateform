package com.webservicemobile.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author cesi
 */
@Entity
@Table(name="devices")
public class Device 
{   
    
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="ID")
    private Long ID;
    @Column(name="User_OID")
    private String User_OID;
    @Column(name="DeviceName")
    private String DeviceName;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getUser_OID() {
        return User_OID;
    }

    public void setUser_OID(String User_OID) {
        this.User_OID = User_OID;
    }

    public String getDeviceName() {
        return DeviceName;
    }

    public void setDeviceName(String DeviceName) {
        this.DeviceName = DeviceName;
    }
    
    
    
}
