/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservicemobile.mobileapi;

/**
 *
 * @author cesi
 */
public class DeviceModel {
  
    private String ID;
    private String User_OID;
    private String DeviceName;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
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
