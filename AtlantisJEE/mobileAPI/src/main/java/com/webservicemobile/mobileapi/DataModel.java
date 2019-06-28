/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservicemobile.mobileapi;

import javax.persistence.Column;

/**
 *
 * @author cesi
 */
public class DataModel {
    
    private Long Id;
    private String Device_Id;
    private String MetricValue;
    private String MetricDate;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getDevice_Id() {
        return Device_Id;
    }

    public void setDevice_Id(String Device_Id) {
        this.Device_Id = Device_Id;
    }

    public String getMetricValue() {
        return MetricValue;
    }

    public void setMetricValue(String MetricValue) {
        this.MetricValue = MetricValue;
    }

    public String getMetricDate() {
        return MetricDate;
    }

    public void setMetricDate(String MetricDate) {
        this.MetricDate = MetricDate;
    }
    
}
