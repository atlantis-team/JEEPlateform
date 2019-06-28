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
public class Metrics 
{
    
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="ID")
    private Long ID;
    @Column(name="User_ID")
    private String User_ID;
    @Column(name="MetricValue")
    private String MetricValue;
    @Column(name="MetricDate")
    private String MetricDate;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(String User_ID) {
        this.User_ID = User_ID;
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
