/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.getmetrics.service;

import com.webservice.getmetrics.domain.Metrics;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cesi
 */
@Local
public interface MetricServiceLocal {
    
    public List<Metrics> selectLastMetrics(int deviceId);
}
