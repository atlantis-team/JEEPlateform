/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservicejms.service;

import com.webservicejms.domain.Device;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cesi
 */
@Local
public interface DeviceServiceLocal 
{
    //public void addDevice(String String ID, String User_ID, String DeviceName);
    public List<Device> select(String MacAdress);
    
    public void save(Device device);
}
