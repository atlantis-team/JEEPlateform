/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservicejms.controller;

import com.google.gson.Gson;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author cesi
 */
@Named(value = "jMSJSFManagedBean")
@SessionScoped
public class JMSJSFManagedBean implements Serializable {

    @Resource(mappedName = "queueDest")
    private Queue queueDest;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    public JMSJSFManagedBean() {
    }

    private void sendJMSMessageToQueueDest(String messageData) {
        context.createProducer().send(queueDest, messageData);
    }
    
    public void send(MetricsModel metricModel){
        Gson gson = new Gson();
        this.sendJMSMessageToQueueDest(gson.toJson(metricModel));
    }
    
}
