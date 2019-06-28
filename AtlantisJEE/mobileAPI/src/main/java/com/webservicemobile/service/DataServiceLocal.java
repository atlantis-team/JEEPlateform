/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservicemobile.service;

import com.webservicemobile.domain.Data;
import javax.ejb.Local;

/**
 *
 * @author cesi
 */
@Local
public interface DataServiceLocal 
{
    public void addData(String Device_Id, String MetricValue, String MetricDate);
    
    public void save(Data data);
}
