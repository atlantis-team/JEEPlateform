/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.getmetrics.service;

import com.webservice.getmetrics.dao.MetricsDAO;
import com.webservice.getmetrics.domain.Metrics;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author cesi
 */
@Stateless
public class MetricService implements MetricServiceLocal {

    @Inject
    MetricsDAO metricDAO;
    
    @Override
    public List<Metrics> selectLastMetrics(int deviceId) {
        System.out.println("Select last metrics");
        return metricDAO.getLastMetrics(deviceId);
    }
    
}
