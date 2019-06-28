package com.webservicemobile.domain;

import javax.persistence.*;

/**
 *
 * @author cesi
 */
@Entity
@Table(name="Metrics")
public class Data 
{
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="ID")
    private Long Id;
    
    @Column(name="Device_Id")
    private String Device_Id;
    @Column(name="MetricValue")
    private String MetricValue;
    @Column(name="MetricDate")
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
