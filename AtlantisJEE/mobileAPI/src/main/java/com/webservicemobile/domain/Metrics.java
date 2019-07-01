package com.webservicemobile.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author cesi
 */
@Entity
@Table(name="Metrics")
public class Metrics 
{
    
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="ID")
    private Long ID;
    @Column(name="Device_ID")
    private int Device_ID;
    @Column(name="MetricValue")
    private float MetricValue;
    @Column(name="MetricDate")
    private String MetricDate;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public int getDevice_ID() {
        return Device_ID;
    }

    public void setDevice_ID(int Device_ID) {
        this.Device_ID = Device_ID;
    }

    public float getMetricValue() {
        return MetricValue;
    }

    public void setMetricValue(float MetricValue) {
        this.MetricValue = MetricValue;
    }

    public String getMetricDate() {
        return MetricDate;
    }

    public void setMetricDate(String MetricDate) {
        this.MetricDate = MetricDate;
    }

    public String toString() {
        return "[" + ID + "] : device_ID : " +Device_ID + ",Value : " + MetricValue + ", date ; " + MetricDate;
    }


}
