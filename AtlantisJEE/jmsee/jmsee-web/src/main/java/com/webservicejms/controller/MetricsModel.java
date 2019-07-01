package com.webservicejms.controller;

/**
 *
 * @author cesi
 */
public class MetricsModel 
{
    private int Device_ID;
    private float MetricValue;
    private String MetricDate;

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
}
