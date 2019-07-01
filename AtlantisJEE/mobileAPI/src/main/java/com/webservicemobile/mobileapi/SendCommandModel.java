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
public class SendCommandModel {
    public String token;
    public int deviceId;
    public Boolean command;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public Boolean getCommand() {
        return command;
    }

    public void setCommand(Boolean command) {
        this.command = command;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        return sb.append(token).append(" ").append(deviceId).append(" ").append(command).toString();
    }
}
